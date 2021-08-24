package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();

    public void adiciona(Produto produto) {
        if (produtos.contains(produto)) {
            throw new IllegalArgumentException("Produto já cadastrado!");
        } else if (produto.getPreco() <= 0){
            throw new IllegalArgumentException("Preço deve ser maior que zero!");
        } else if (produto.getQuantidadeEstoque() < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa!");
        } else {
            this.produtos.add(produto);
        }
    }

    public Produto consulta(Produto produto) {
       produtos.forEach(p ->{
           if (p.equals(produto)){
               //return p;
           }
       });
       return null;
    }

    public void remove(Produto produto) {
        this.produtos.remove(produto);
    }
}
