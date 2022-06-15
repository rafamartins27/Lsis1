package DB;

import static DB.DAL.*;
import InternalClasses.Competicao;
import InternalClasses.Equipa;
import InternalClasses.Robot;
import InternalClasses.Ronda;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import java.sql.Date;

/**
 *
 * @author Misterio
 */
class Handlers {
    //    List<Aluno> BDfalsa = new ArrayList<>();
    String webRoot = "src/main/java/webroot";

    Repository repo;
//    BotTelegram bot;

    public Handlers(Repository repo/*, BotTelegram bot*/) {
        this.repo = repo;
//        this.bot = bot;
    }

    public void registarCompeticao(RoutingContext rc) {
        String nomeCompeticao = rc.request().getParam("nome_Comp");
        String data_criacao = rc.request().getParam("data_criacao");
        Competicao copm_nova = new Competicao(nomeCompeticao, data_criacao);
        criarCompeticao(copm_nova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void registarRonda(RoutingContext rc) {
        String id_Comp = rc.request().getParam("id_Comp");
        int id_CompFinal = Integer.parseInt(id_Comp);
        String tipo = rc.request().getParam("tipo");
        Ronda ronda_nova = new Ronda(tipo, id_CompFinal);
        criarRonda(ronda_nova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void registarEquipa(RoutingContext rc) {
        String Nome = rc.request().getParam("Nome");
        Equipa equipa_nova = new Equipa(Nome);
        criarEquipa(equipa_nova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void registarRobot(RoutingContext rc) {
        String id_Equipa = rc.request().getParam("id_Equipa");
        int id_EquipaFinal = Integer.parseInt(id_Equipa);
        String nome_robo = rc.request().getParam("nome_robo");
        String macAdress = rc.request().getParam("macAdress");
        Robot robot_novo = new Robot(nome_robo, macAdress, id_EquipaFinal);
        criarRobot(robot_novo);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }
}
