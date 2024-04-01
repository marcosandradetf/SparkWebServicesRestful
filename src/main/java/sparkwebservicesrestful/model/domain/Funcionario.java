package sparkwebservicesrestful.model.domain;

import java.lang.invoke.StringConcatException;
import java.util.Date;


public class Funcionario {
    private Integer id;
    private String nome;
    private String dataNasicmento;
    private String cargo;
    private String email;
    private String telefone;

    public Funcionario(String nome, String dataNasicmento, String cargo, String email, String telefone) {
        this.nome = nome;
        this.dataNasicmento = dataNasicmento;
        this.cargo = cargo;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasicmento() {
        return dataNasicmento;
    }

    public void setDataNasicmento(String dataNasicmento) {
        this.dataNasicmento = dataNasicmento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public boolean validarEmail(String email) {
        // Verifica se o e-mail não é nulo e contém "@" e "."
        return email != null && email.contains("@") && email.contains(".");
    }
}
