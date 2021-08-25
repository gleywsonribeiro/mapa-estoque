package modelo;

public class Produto {
    private String nome;
    private double preco;
    private String unidade;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, String unidade, int quantidadeEstoque) {
        setNome(nome);
        setPreco(preco);
        setUnidade(unidade);
        setQuantidadeEstoque(quantidadeEstoque);
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
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero!");
        } else {
            this.preco = preco;
        }
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
        if (quantidadeEstoque < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa!");
        } else {
            this.quantidadeEstoque = quantidadeEstoque;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return nome.equals(produto.nome);
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nPreco: " + preco +
                "\nUnidade: " + unidade +
                "\nQuantidade: " + quantidadeEstoque;
    }
}
