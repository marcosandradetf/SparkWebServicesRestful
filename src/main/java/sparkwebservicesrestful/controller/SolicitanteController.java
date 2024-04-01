package sparkwebservicesrestful.controller;

import spark.Route;
import sparkwebservicesrestful.model.domain.Medico;
import sparkwebservicesrestful.model.domain.Solicitante;
import sparkwebservicesrestful.model.service.MedicoService;
import sparkwebservicesrestful.model.service.SolicitanteService;



public class SolicitanteController {
    private static SolicitanteService solicitanteService;
    
    public static Route obterTodos = (req, res) -> {

        return SolicitanteService.obterTodos();
    };

    public static Route obterTodosArquivados = (req, res) -> {

        return SolicitanteService.obterTodosArquivados();
    };

    public static Route obter = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        return SolicitanteService.obter(index);
    };

    public static Route obterArquivado = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        return SolicitanteService.obterArquivado(index);
    };
    
    public static Route criarSolicitante = (req, res) -> {
        String telefone = req.queryParams("telefone");
        String nome = req.queryParams("nome");
        String logradouro = req.queryParams("logradouro");
        String bairro = req.queryParams("bairro");
        String cidade = req.queryParams("cidade");
        String pontoReferencia = req.queryParams("pontoReferencia");
        
        Solicitante solicitante = new Solicitante(telefone, nome, logradouro, bairro, cidade, pontoReferencia);
        SolicitanteService.criar(solicitante);
        
        return "Chamado gerado com sucesso";
    };
    
    public static Route atualizarSolicitante = (req, res) -> {
        Integer idSolicitante = Integer.valueOf(req.queryParams("idSolicitante"));
        String diagnostico = req.queryParams("diagnostico");
        Integer idMedico = Integer.valueOf(req.queryParams("idMedico"));
        
        Medico medico = MedicoService.obterMedico(idMedico);
        Solicitante solicitante = new Solicitante(diagnostico, medico);
        SolicitanteService.atualizarSolicitante(idSolicitante, solicitante);
        
        return "Ficha atualizada";
    };
    
    
}
