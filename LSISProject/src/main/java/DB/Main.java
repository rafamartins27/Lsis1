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

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new VerticleRSJson());
    }


}
