package br.com.grupo1.gp1_api.security.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.grupo1.gp1_api.security.dto.ProdutoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_cd_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "car_fk_cliente_id")
	@JsonManagedReference
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "carrinho_produto", 
        joinColumns = @JoinColumn(name = "carrinho_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id") 
    )
	@JsonBackReference
    private Set<Produto> produtos = new HashSet<>();

    @Column(name = "car_dbl_total")
    private Double total;

    public Carrinho(Cliente cliente, Set<Produto> produtos, Double total) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.total = total;
    }

    public Carrinho() {
        this.total = 0.0;
    }

    public Carrinho(Set<Produto> produtos) {
        this.produtos = produtos;
        calcularTotal();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
        calcularTotal();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
        this.total += produto.getPreco();
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
        this.total -= produto.getPreco();
    }

    private void calcularTotal() {
        this.total = produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    @Override
    public String toString() {
        return "Carrinho [cliente=" + cliente + ", id=" + id + ", produtos=" + produtos + ", total=" + total + "]";
    }
    
	public Set<ProdutoDTO> listaProdutosToListaProdutosDTO() {
		
		Set<ProdutoDTO> listaProdutosFormatada = new HashSet<>();
		
		for(Produto produto : this.produtos) {
			ProdutoDTO produtoFormatado = new ProdutoDTO();
			Categoria categoria = produto.getCategoria();
			Funcionario funcionario = produto.getFuncionario();
			produtoFormatado.setCategoria(categoria.getDescricao());
			produtoFormatado.setDescricao(produto.getDescricao());
			produtoFormatado.setEstoque(produto.getEstoque());
			produtoFormatado.setIdFuncionario(funcionario.getId());
			produtoFormatado.setNome(produto.getNome());
			produtoFormatado.setPreco(produto.getPreco());
			listaProdutosFormatada.add(produtoFormatado);
		}
		
		return listaProdutosFormatada;
	}
}
