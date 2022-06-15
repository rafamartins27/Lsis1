package DB;

import static DB.DAL.*;
import static DataBase.DAL.actualizarEquipa;
import static DataBase.DAL.actualizarResultadoRobot;
import static DataBase.DAL.actualizarRobot;
import static DataBase.DAL.eliminarRobot;
import static DataBase.DAL.inserirAssociacaoEquipaCompeticao;
import static DataBase.DAL.inserirCompeticao;
import static DataBase.DAL.inserirEquipa;
import static DataBase.DAL.inserirRobot;
import static DataBase.DAL.inserirRonda;
import static DataBase.DAL.obterListaCompeticoes;
import static DataBase.DAL.obterUmaEquipa;
import static DataBase.DAL.obterUmRobot;
import static DataBase.DAL.obterListaEquipas;
import static DataBase.DAL.obterListaRobots;
import static DataBase.DAL.obterListaRobotsDeUmaEquipa;
import static DataBase.DAL.obterListaRondasDeUmaCompeticao;
import static DataBase.DAL.obterResultadoDeUmRobotDeUmaRonda;
import static DataBase.DAL.obterResultadosDeUmaRonda;

import InternalClasses.Competicao;
import InternalClasses.Equipa;
import InternalClasses.Robot;
import InternalClasses.Ronda;
import Model.AssociacaoRobotRonda;
import Model.AssociacaoEquipaCompeticao;
import Model.Competicao;
import Model.Equipa;
import Model.Robot;
import Model.Ronda;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
        Date data_criacao = Date.valueOf(rc.request().getParam("data_criacao"));
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

    public void selecionarEquipa(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        Equipa equipa = obterUmaEquipa(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
        response.end(Json.encodePrettily(equipa));
    }

    public void updateEquipa(RoutingContext rc) {
        String idEquipa = rc.request().getParam("teamId");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        String nomeEquipa = rc.request().getParam("teamNameId");
        actualizarEquipa(idEquipaFinal, nomeEquipa);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void selecionarRobot(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        Robot robot = obterUmRobot(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
        response.end(Json.encodePrettily(robot));
    }

    public void updateRobot(RoutingContext rc) {
        String idRobot = rc.request().getParam("id");
        int idRobotFinal = Integer.parseInt(idRobot);
        String nomeRobot = rc.request().getParam("robotName");
        String macAddress = rc.request().getParam("macAddress");
        actualizarRobot(idRobotFinal, nomeRobot, macAddress);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void deleteRobot(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        eliminarRobot(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
    }

    public void obterCompeticoes(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Competicao> listaCompeticoes = new ArrayList<>();
        obterListaCompeticoes(listaCompeticoes);
        System.out.println(listaCompeticoes.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaCompeticoes));
    }

    public void inscricaoEquipaCompeticao(RoutingContext rc) {
        String idCompeticao = rc.request().getParam("idCompeticao");
        int idCompeticaoFinal = Integer.parseInt(idCompeticao);
        String idEquipa = rc.request().getParam("teamId");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        AssociacaoEquipaCompeticao associacaoEquipaCompeticaoNova = new AssociacaoEquipaCompeticao(idEquipaFinal, idCompeticaoFinal);
        inserirAssociacaoEquipaCompeticao(associacaoEquipaCompeticaoNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void obterEquipas(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Equipa> listaEquipas = new ArrayList<>();
        obterListaEquipas(listaEquipas);
        System.out.println(listaEquipas.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaEquipas));
    }

    public void obterRobots(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Robot> listaRobots = new ArrayList<>();
        obterListaRobots(listaRobots);
        System.out.println(listaRobots.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaRobots));
    }

    public void obterRobotsDeUmaEquipa(RoutingContext rc) {
        String idEquipa = rc.request().getParam("id");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Robot> listaRobots = new ArrayList<>();
        obterListaRobotsDeUmaEquipa(listaRobots, idEquipaFinal);
        System.out.println(listaRobots.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaRobots));
    }

    public void obterRondasDeUmaCompeticao(RoutingContext rc) {
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

    public void obterResultadosRonda(RoutingContext rc) {
        String idRonda = rc.request().getParam("id");
        int idRondaFinal = Integer.parseInt(idRonda);
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<AssociacaoRobotRonda> listaAssociacaoRobotRonda = new ArrayList<>();
        obterResultadosDeUmaRonda(listaAssociacaoRobotRonda, idRondaFinal);
        System.out.println(listaAssociacaoRobotRonda.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaAssociacaoRobotRonda));
    }

    public void obterResultadoDeUmRobot(RoutingContext rc) {
        String idRonda = rc.request().getParam("id");
        String idRobot = rc.request().getParam("idRobot");
        int idRondaFinal = Integer.parseInt(idRonda);
        int idRobotFinal = Integer.parseInt(idRobot);
        AssociacaoRobotRonda robotRonda = obterResultadoDeUmRobotDeUmaRonda(idRobotFinal, idRondaFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
        response.end(Json.encodePrettily(robotRonda));
    }

    public void updateResultadoRobot(RoutingContext rc) {
        String idAssociacaoRonda = rc.request().getParam("association");
        String idRobot = rc.request().getParam("robot");
        String tempo = rc.request().getParam("tempo");
        String velocidade = rc.request().getParam("velocidade");
        int idAssociacaoRondaFinal = Integer.parseInt(idAssociacaoRonda);
        int idRobotFinal = Integer.parseInt(idRobot);
        double tempoFinal = Double.parseDouble(tempo);
        double velocidadeFinal = Double.parseDouble(velocidade);
        actualizarResultadoRobot(idAssociacaoRondaFinal, idRobotFinal, tempoFinal, velocidadeFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }
}
