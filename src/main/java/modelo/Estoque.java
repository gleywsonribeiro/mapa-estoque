package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();

    public void adiciona(Produto produto) throws IllegalArgumentException {
        if (produtos.contains(produto)) {
            throw new IllegalArgumentException("Produto já cadastrado!");
        } else {
            this.produtos.add(produto);
        }
    }

    public Produto consulta(String nome) {
        Optional<Produto> busca = produtos.stream().filter(p -> p.getNome().equals(nome)).findFirst();
        if (busca.isPresent()) {
            return busca.get();
        } else {
            throw new NoSuchElementException("Produto não encontrado");
        }
    }

    public void atualiza(Produto produto) {
        for (Produto p : produtos) {
            if (p.equals(produto)) {
                p.setPreco(produto.getPreco());
                p.setUnidade(produto.getUnidade());
            }
        }
    }

    public void remove(Produto produto) {
        this.produtos.remove(produto);
    }

    public void printRelatorio() {

        System.out.println("|------RELATÓRIO DE PRODUTOS------|");
        produtos.forEach(produto -> {
            System.out.println(produto);
            System.out.println("|---------------------------------|");
        });
    }

    public void reajuste(double taxa) {
        produtos.forEach(produto -> {
            double novoValor = produto.getPreco() * (1  + taxa);
            produto.setPreco(novoValor);
        });
    }
}
