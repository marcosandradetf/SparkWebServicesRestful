package sparkwebservicesrestful.controller;

import spark.Route;
import sparkwebservicesrestful.model.domain.Medico;
import sparkwebservicesrestful.model.service.MedicoService;

public class MedicoController {
    public static Route obterTodos = (req, res) -> {

        return MedicoService.obterTodos();
    };
    

    public static Route obter = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        return MedicoService.obter(index);
    };
    
    public static Route criarMedico = (req, res) -> {
        String nome = req.queryParams("medicoNome");
        String dataNasicmento = req.queryParams("dataNasicmento");
        String cargo = req.queryParams("cargo");
        String email = req.queryParams("email");
        String telefone = req.queryParams("medicoTelefone");
        String crm = req.queryParams("crm");
        
        Medico medico = new Medico(nome, dataNasicmento, cargo, email, telefone, crm);
        

        if (!medico.validarCrm(medico.getCrm())) {
            return "Médico não cadastrado com sucesso: CRM inválido (Exemplo de formato: AA1234)";
        }
        
        MedicoService.criar(medico);
        return "Médico cadastrado com sucesso";
    };
    
    
    
}
