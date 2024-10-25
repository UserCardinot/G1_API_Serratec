package br.com.grupo1.gp1_api.security.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.grupo1.gp1_api.security.dto.ProdutoDTO;
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

	@ManyToOne
	@JoinColumn(name = "pro_fk_categoria")
	@JsonManagedReference
	private Categoria categoria;

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
	@JsonManagedReference
	private Funcionario funcionario;

	public Produto() {
	}

	public Produto(Categoria categoria, String nome, String descricao, Integer estoque, Double preco,
			Funcionario funcionario) {
		this.categoria = categoria;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ProdutoDTO toProdutoDTO() {

		ProdutoDTO produtoDTO = new ProdutoDTO();
		Categoria categoria = this.getCategoria();
		Funcionario funcionario = this.getFuncionario();
		produtoDTO.setCategoria(categoria.getDescricao());
		produtoDTO.setDescricao(this.getDescricao());
		produtoDTO.setEstoque(this.getEstoque());
		produtoDTO.setIdFuncionario(funcionario.getId());
		produtoDTO.setNome(this.getNome());
		produtoDTO.setPreco(this.getPreco());

		return produtoDTO;
	}

}