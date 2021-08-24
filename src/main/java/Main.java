import modelo.Estoque;
import modelo.Produto;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Estoque estoque = new Estoque();

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA - SISTEMA DE CONTROLE DE ESTOQUE");

        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.print("##-------MENU PRINCIPAL------##\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| 1 - CADASTRO DE PRODUTOS    |\n");
            System.out.print("| 2 - MOVIMENTAÇÃO            |\n");
            System.out.print("| 3 - REAJUSTE DE PREÇOS      |\n");
            System.out.print("| 4 - RELATÓRIOS              |\n");
            System.out.print("| 0 - FINALIZAR               |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = entrada.nextInt();

            if (opcao == 0) {
                System.out.print("\nAté logo!");
                entrada.close();
            }

            switch (opcao) {
                case 1:
                    produto();
                    break;
                case 2:
                    movimentacao();
                    break;
                case 3:
                    System.out.print("\nREAUSTE DE PREÇOS\n");
                    break;
                case 4:
                    System.out.println("\nRELATÓRIOS");
                case 0:
                    break;
                default:
                    System.out.print("\nOpção Inválida!");
                    break;
            }
        } while (opcao != 0);

    }

    public static void produto() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.print("##---CADASTRO DE PRODUTOS----##\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| 1 - INCLUSAO    |\n");
            System.out.print("| 2 - ALTERACAO   |\n");
            System.out.print("| 3 - CONSULTA    |\n");
            System.out.print("| 4 - EXCLUSAO    |\n");
            System.out.print("| 0 - RETORNAR    |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    inclusao();
                    break;
                case 2:
                    System.out.println("Alteração de Produto");
                    break;
                case 3:
                    System.out.println("Consulta de produtos");
                    break;
                case 4:
                    System.out.println("Exclusão de produtos");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    public static void movimentacao() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.print("##---MOVIMENTACAO----##\n");
            System.out.print("|----------------------|\n");
            System.out.print("| 1 - ENTRADA          |\n");
            System.out.print("| 2 - SAIDA            |\n");
            System.out.print("| 0 - RETORNAR         |\n");
            System.out.print("|----------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Entrada");
                    break;
                case 2:
                    System.out.println("Saída");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    public static void inclusao() {
        char op = 'n';
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("##---INCLUSAO DE PRODUTO----##\n");

            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("Preço: ");
            double preco = input.nextDouble();

            System.out.print("Unidade: ");
            input.nextLine();
            String unidade = input.nextLine();

            System.out.print("Quantidade: ");
            int quantidade = input.nextInt();


            char sn = 'n';
            do {
                System.out.print("CONFIRMA INCLUSAO? \n(s/n): ");
                sn = input.next().charAt(0);
                switch (sn) {
                    case 's':
                        Produto produto = new Produto(nome, preco, unidade, quantidade);
                        try {
                            estoque.adiciona(produto);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 'n':
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (sn != 's' && sn != 'n');


            do {
                System.out.print("REPETIR OPERACAO? \n(s/n): ");
                op = input.next().charAt(0);
                switch (op) {
                    case 's':
                        break;
                    case 'n':
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (op != 's' && op != 'n');

        } while (op != 'n');


    }
//    public static void
}