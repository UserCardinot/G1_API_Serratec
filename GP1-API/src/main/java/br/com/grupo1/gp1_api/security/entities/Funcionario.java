package br.com.grupo1.gp1_api.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fun_cd_id")
    private Integer id;

    @Column(name = "fun_txt_nome")
    private String nome;

    @Size(max = 20)
    @Column(name = "fun_txt_password")
    private String password;

    @Column(name = "fun_int_salario")
    private Double salario;

    @Column(name = "fun_txt_cargo")
    private String cargo;

    @Column(name = "fun_txt_telefone")
    private String telefone;

    public Funcionario() {
    }

    public Funcionario(String nome, String password, Double salario, String cargo, String telefone) {
        this.nome = nome;
        this.password = password;
        this.salario = salario;
        this.cargo = cargo;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public Double getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}