package sparkwebservicesrestful.model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sparkwebservicesrestful.model.domain.Funcionario;
import sparkwebservicesrestful.model.domain.Medico;
import sparkwebservicesrestful.model.domain.Solicitante;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class SolicitanteService {
    private static Map<Integer, Solicitante> solicitanteRepository = new HashMap<>();
    private static Map<Integer, Solicitante> solicitanteRepositoryArquivo = new HashMap<>();
    
    private static Integer id = 0;
    
    public static String obterTodos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(solicitanteRepository.values());
        } catch (Exception e) {
            e.printStackTrace(); // Trate a exceção de acordo com suas necessidades
            return null;
        }
    }

    public static String obterTodosArquivados() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(solicitanteRepositoryArquivo.values());
        } catch (Exception e) {
            e.printStackTrace(); // Trate a exceção de acordo com suas necessidades
            return null;
        }
    }

    public static String obter(Integer id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(solicitanteRepository.get(id));
        } catch (Exception e) {
            e.printStackTrace(); // Trate a exceção de acordo com suas necessidades
            return null;
        }
    }

    public static String obterArquivado(Integer id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(solicitanteRepositoryArquivo.get(id));
        } catch (Exception e) {
            e.printStackTrace(); // Trate a exceção de acordo com suas necessidades
            return null;
        }
    }

    public static void criar(Solicitante solicitante) {
        solicitante.setId(++id);
        
        solicitanteRepository.put(solicitante.getId(), solicitante);
    }
    
    public static void atualizarSolicitante(Integer id, Solicitante solicitanteAtualizado) {
        Solicitante solicitante = solicitanteRepository.get(id);

        if (solicitante.getDiagnostico() == null) {
            solicitante.setDiagnostico(solicitanteAtualizado.getDiagnostico());
        }
        
        if(solicitante.getMedico() == null) {
            solicitante.setMedico(solicitanteAtualizado.getMedico());
        }
        solicitanteRepositoryArquivo.put(id, solicitante);
        solicitanteRepository.remove(solicitante.getId());
    }
    

    public static void excluir(Integer id) {
        solicitanteRepository.remove(id);;
    }
    
}
