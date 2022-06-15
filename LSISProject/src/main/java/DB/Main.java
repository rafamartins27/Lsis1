package DB;

import InternalClasses.Competicao;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.file.FileSystemOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static DB.DAL.criarCompeticao;
import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;

public class Main extends AbstractVerticle {

    private String webRoot = DEFAULT_WEB_ROOT;
    public void start(Promise<Void> promise) throws Exception {
        Router router = Router.router(vertx);

        router.route(HttpMethod.GET, "/*").handler(StaticHandler.create(webRoot));
        router.route().handler(BodyHandler.create());

        router.route(HttpMethod.POST, "/registarCompeticao").handler(this::addCompeticao);

        // create HTTP server
        HttpServerOptions options = new HttpServerOptions();
        options.setPort(3001);
        vertx.createHttpServer(options)
                .requestHandler(router)
                .listen(res -> {
                    if (res.succeeded()) {
                        promise.complete();
                    } else {
                        promise.fail(res.cause());
                    }
                });
    }

    public static void main(String[] args) {
        FileSystemOptions fsOptions = new FileSystemOptions();
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new Main());
    }

    private void addCompeticao(RoutingContext rc) {
        try {
            String nomeCompeticao = rc.request().getParam("reg_comp");
            long time = Calendar.getInstance().getTimeInMillis();
            Date date = new Date(time);
            String createDate = new SimpleDateFormat("yyyy-MM-dd").format(date);

            Competicao competicao = new Competicao(nomeCompeticao, createDate);
            criarCompeticao(competicao);
            HttpServerResponse response = rc.response();
            response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
