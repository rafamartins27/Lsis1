package DB;

import InternalClasses.Bot;
import InternalClasses.MQTTCli;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 *
 * @author Misterio
 */
public class VerticleRSJson extends AbstractVerticle {

    String webRoot = DEFAULT_WEB_ROOT;
    Router router;
    MQTTCli mqttCli;
    Bot bot;

    @Override
    public void start(Promise<Void> startPromise) throws Exception {


        bot = new Bot(vertx);
        //telegramBot(bot);


        Repository repo = new Repository();
        Handlers handlers = new Handlers(repo, bot);
        router = routes(handlers);

        mqttCli = new MQTTCli(vertx, repo);

        HttpServerOptions options = new HttpServerOptions();
        options.setHost("127.0.0.1").setPort(4000);

        vertx.createHttpServer(options)
                .requestHandler(router) //usa o router para manipular qualquer pedido
                .listen(res -> {
                    if (res.succeeded()) {
                        startPromise.complete();
                        System.out.println("Servidor HTTP no porto " + options.getPort());
                    } else {
                        startPromise.fail(res.cause());
                        System.out.println("Nao foi possivel iniciar o servidor HTTP");
                    }
                });
    }

    private Router routes(Handlers handlers) {
        router = Router.router(vertx);

        router.route().handler(StaticHandler.create().setWebRoot(webRoot));
        // serve index
        router.route("/").handler(StaticHandler.create(webRoot));

        /*
        router.route(HttpMethod.GET, "/alunosJson").handler(handlers::sendStringJson);
        router.route(HttpMethod.GET, "/alunosString").handler(handlers::sendArrayAsString);
        router.route(HttpMethod.GET, "/paginaNova")
                .handler(handlers::paginaNova);//ou StaticHandler.create(webRoot + "/html/nova1.html"));
        router.route(HttpMethod.GET, "/paginaNova2")
                .handler(handlers::paginaNova2);//ou StaticHandler.create(webRoot + "/html/nova1.html")); */

        // ATENÇÃO: necessário usar "bodyHandler" quando se pretende ler o body do pedido
        //  - nos POST seguintes o body contém os dados do aluno
        /*
        router.route("/alunos/*").handler(BodyHandler.create());
        // criarALuno() e actualizarALuno() estão na classe Handlers
        router.route(HttpMethod.POST, "/alunos").handler(handlers::criarAluno);
        router.route(HttpMethod.PUT, "/alunos/:numAluno").handler(handlers::actualizarAluno);
        */
        router.route().handler(BodyHandler.create());
        router.route(HttpMethod.POST, "/registarCompeticao").handler(handlers::addCompeticao);

        router.route(HttpMethod.POST, "/registarRonda").handler(handlers::addRonda);

        router.route(HttpMethod.POST, "/registarEquipa").handler(handlers::addEquipa);

        router.route(HttpMethod.POST, "/registarRobo").handler(handlers::addRobot);

        router.route(HttpMethod.POST, "/registarJuri").handler(handlers::addJuri);

        return router;
    }

    public void telegramBot(Bot bot) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace(System.out);
        }
    }
}
