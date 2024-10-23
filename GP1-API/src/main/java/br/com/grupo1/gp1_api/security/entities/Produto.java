package br.com.grupo1.gp1_api.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_cd_id")
    private Integer id;

    @Column(name = "pro_txt_nome")
    private String nome;

    @Column(name = "pro_txt_descricao")
    private String descricao;

    @Column(name = "pro_int_estoque")
    private Integer estoque;

    @Column(name = "pro_dbl_preco")
    private Double preco;

    @ManyToOne
	@JoinColumn(name = "pro_fk_funcionario", nullable = false)
	private Funcionario funcionario;

    public Produto() {
    }

    public Produto(String nome, String descricao, Integer estoque, Double preco, Funcionario funcionario) {
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
        this.preco = preco;
        this.funcionario = funcionario;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

}