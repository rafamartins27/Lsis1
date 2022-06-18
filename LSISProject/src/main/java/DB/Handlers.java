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
        ElementosJuri juri_novo = new ElementosJuri(nome_juri, 5);
        criarJuri(juri_novo);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void getCompeticoes(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Competicao> listaCompeticoes = new ArrayList<>();
        obterListaCompeticoes(listaCompeticoes);
        System.out.println(listaCompeticoes.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaCompeticoes));
    }

    public void getEquipas(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Equipa> listaEquipas = new ArrayList<>();
        obterListaEquipas(listaEquipas);
        System.out.println(listaEquipas.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaEquipas));
    }

    public void getRondas(RoutingContext rc) {
        String idCompeticao = rc.request().getParam("id");
        int idCompeticaoFinal = Integer.parseInt(idCompeticao);
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Ronda> listaRondas = new ArrayList<>();
        obterListaRondasDeUmaCompeticao(listaRondas, idCompeticaoFinal);
        System.out.println(listaRondas.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaRondas));
    }

    public void getRobos(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Robot> listaRobos = new ArrayList<>();
        obterListaRobots(listaRobos);
        System.out.println(listaRobos.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaRobos));
    }
}
