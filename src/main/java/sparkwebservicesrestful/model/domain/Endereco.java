package sparkwebservicesrestful.model.domain;

import jakarta.persistence.*;

import java.util.List;

public class Endereco {
    private Integer id;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String pontoReferencia;
    
    private List<Solicitante> solicitantes;

    public Endereco() {
    }


    public Endereco(String logradouro, String bairro, String cidade, String pontoReferencia) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.pontoReferencia = pontoReferencia;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public List<Solicitante> getSolicitantes() {
        return solicitantes;
    }

    public void addSolicitante(Solicitante solicitante) {
        this.solicitantes.add(solicitante);
    }
}
