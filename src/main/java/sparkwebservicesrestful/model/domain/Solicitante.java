package sparkwebservicesrestful.model.domain;

import java.util.List;

public class Solicitante extends Endereco{
    private String nome;
    private String telefone;
    private String diagnostico;
    // Relacionamento 1 para 1
    private Medico medico;

    
    public Solicitante(String telefone, String nome, String logradouro, String bairro, String cidade, String pontoReferencia) {
        super(logradouro, bairro, cidade, pontoReferencia);
        this.setNome(nome);
        this.setTelefone(telefone);
        //this.addSolicitante(this);
    }
    
    // relacao 1 para 1
    public Solicitante(String diagnostico, Medico medico) {
        this.setDiagnostico(diagnostico);
        this.setMedico(medico);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTelefone() {
        return telefone;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public String getLogradouro() {
        return super.getLogradouro();
    }

    @Override
    public void setLogradouro(String logradouro) {
        super.setLogradouro(logradouro);
    }

    @Override
    public String getBairro() {
        return super.getBairro();
    }

    @Override
    public void setBairro(String bairro) {
        super.setBairro(bairro);
    }

    @Override
    public String getCidade() {
        return super.getCidade();
    }

    @Override
    public void setCidade(String cidade) {
        super.setCidade(cidade);
    }

    @Override
    public String getPontoReferencia() {
        return super.getPontoReferencia();
    }

    @Override
    public void setPontoReferencia(String pontoReferencia) {
        super.setPontoReferencia(pontoReferencia);
    }
    
    @Override
    public void addSolicitante(Solicitante solicitante) {
        super.addSolicitante(solicitante);
    }

    public boolean validarDiagnostico(String diagnostico) {
        return diagnostico != null && diagnostico.length() >= 4;
    }
}
