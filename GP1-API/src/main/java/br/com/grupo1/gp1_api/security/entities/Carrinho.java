package br.com.grupo1.gp1_api.security.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_cd_id")
    private Integer id;

    @ManyToMany
    @JoinTable(
        name = "carrinho_produto", 
        joinColumns = @JoinColumn(name = "carrinho_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id") 
    )
    private Set<Produto> produtos = new HashSet<>();

    @Column(name = "car_dbl_total")
    private Double total;

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
}
