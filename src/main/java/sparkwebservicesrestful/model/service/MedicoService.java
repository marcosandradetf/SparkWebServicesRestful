package sparkwebservicesrestful.model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sparkwebservicesrestful.model.domain.Medico;
import sparkwebservicesrestful.model.domain.Solicitante;

import java.util.HashMap;
import java.util.Map;


public class MedicoService {
    private static Map<Integer, Medico> medicoRepository = new HashMap<>();
    
    private static Integer id = 0;
    
    public static String obterTodos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(medicoRepository.values());
        } catch (Exception e) {
            e.printStackTrace(); // Trate a exceção de acordo com suas necessidades
            return null;
        }
    }
    
    public static Medico obterMedico(Integer id) {
        return medicoRepository.get(id);
    }

    public static String obter(Integer id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(medicoRepository.get(id));
        } catch (Exception e) {
            e.printStackTrace(); // Trate a exceção de acordo com suas necessidades
            return null;
        }
    }

    public static void criar(Medico medico) {
        medico.setId(++id);

        medicoRepository.put(medico.getId(), medico);
    }
    
    public static void atualizarMedico(Medico medico) {
        medico.setId(id);
        medicoRepository.put(medico.getId(), medico);
    }

    public static void excluir(Integer id) {
        medicoRepository.remove(id);;
    }
    
}
