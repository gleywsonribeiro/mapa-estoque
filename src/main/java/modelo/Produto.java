package modelo;

public class Produto {
    private String nome;
    private double preco;
    private String unidade;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, String unidade, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
