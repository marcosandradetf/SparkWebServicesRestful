package sparkwebservicesrestful;

import spark.Spark;
import sparkwebservicesrestful.controller.MedicoController;
import sparkwebservicesrestful.controller.SolicitanteController;


public class App {

    public static void main(String[] args) {

        Spark.port(8080);

        // Iniciar Spark
        Spark.init();

        Spark.get("/script.js", (req, res) -> {
            res.type("application/javascript");
            return App.class.getResourceAsStream("/script.js");
        });


        Spark.get("/", (req, res) -> {
            return App.class.getResourceAsStream("/index.html");
        });

        // Solicitantes
        Spark.get("/api/solicitante/get", SolicitanteController.obterTodos);
        Spark.post("/api/solicitante/post", SolicitanteController.criarSolicitante);
        Spark.get("/api/solicitante/:id/get", SolicitanteController.obter);
        Spark.put("/api/solicitante/:id/update", SolicitanteController.atualizarSolicitante);
        Spark.get("/api/arquivo_solicitante/get", SolicitanteController.obterTodosArquivados);
        Spark.get("/api/arquivo_solicitante/:id/get", SolicitanteController.obterArquivado);
        
        // Medicos
        Spark.post("/api/medico/post", MedicoController.criarMedico);
        Spark.get("/api/medico/get", MedicoController.obterTodos);
    }
}