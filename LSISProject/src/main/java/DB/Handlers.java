package DB;

import static DB.DAL.*;

import InternalClasses.*;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Misterio
 */
class Handlers {
    //    List<Aluno> BDfalsa = new ArrayList<>();
    String webRoot = "src/main/java/webroot";

    Repository repo;
    Bot bot;

    public Handlers(Repository repo, Bot bot) {
        this.repo = repo;
        this.bot = bot;
    }

    public void addCompeticao(RoutingContext rc) {

        String nomeCompeticao = rc.request().getParam("comp_nome");
        long time = Calendar.getInstance().getTimeInMillis();
        java.util.Date date = new Date(time);
        String createDate = new SimpleDateFormat("yyyy-MM-dd").format(date);

        Competicao competicao = new Competicao(nomeCompeticao, createDate);
        criarCompeticao(competicao);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");

    }

    public void addRonda(RoutingContext rc) {


        String tipoRonda = rc.request().getParam("ronda_tipo");
        String nomeRonda = rc.request().getParam("ronda_nome");

        Ronda ronda = new Ronda(1, tipoRonda, nomeRonda);
        criarRonda(ronda);

        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");

    }

    public void addEquipa(RoutingContext rc) {
        String Nome = rc.request().getParam("equipa_nome");
        long time = Calendar.getInstance().getTimeInMillis();
        java.util.Date date = new Date(time);
        String createDate = new SimpleDateFormat("yyyy-MM-dd").format(date);

        Equipa equipa_nova = new Equipa(Nome, createDate);
        criarEquipa(equipa_nova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void addRobot(RoutingContext rc) {

        String nome_robo = rc.request().getParam("robo_nome");
        String macAdress = rc.request().getParam("mac_adress");
        Robot robot_novo = new Robot(nome_robo, macAdress, 2, 3);
        criarRobot(robot_novo);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void addJuri(RoutingContext rc) {

        String nome_juri = rc.request().getParam("juri_nome");
        ElementosJuri juri_novo = new ElementosJuri(nome_juri, 3);
        criarJuri(juri_novo);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }
}
