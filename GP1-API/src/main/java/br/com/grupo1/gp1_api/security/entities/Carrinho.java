package br.com.grupo1.gp1_api.security.entities;

import java.util.HashSet;
import java.util.Set;

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
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "carrinho_produto", 
        joinColumns = @JoinColumn(name = "carrinho_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id") 
    )
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
}
