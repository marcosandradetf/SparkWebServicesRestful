package sparkwebservicesrestful.model.domain;

public class Medico extends Funcionario {
    private Integer id;
    private String crm;
    private Solicitante solicitante;

    public Medico(String nome, String dataNascimento, String cargo, String email, String telefone, String crm) {
        super(nome, dataNascimento, cargo, email, telefone);
        this.setCrm(crm);
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getDataNasicmento() {
        return super.getDataNasicmento();
    }

    @Override
    public void setDataNasicmento(String dataNasicmento) {
        super.setDataNasicmento(dataNasicmento);
    }

    @Override
    public String getCargo() {
        return super.getCargo();
    }

    @Override
    public void setCargo(String cargo) {
        super.setCargo(cargo);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getTelefone() {
        return super.getTelefone();
    }

    @Override
    public void setTelefone(String telefone) {
        super.setTelefone(telefone);
    }
}
