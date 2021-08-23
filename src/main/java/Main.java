import modelo.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        char op = 'N';
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("##---INCLUSAO DE PRODUTO----##\n");

            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("Preço: ");
            double preco = input.nextDouble();
            input.next();

            System.out.print("Unidade: ");
            String unidade = input.nextLine();

            System.out.print("Quantidade: ");
            int quantidade = input.nextInt();

            System.out.print("CONFIRMA INCLUSAO? \n(S/N): ");
            char sn = input.nextLine().charAt(0);

            if (sn == 'S') {
                Produto produto = new Produto(nome, preco, unidade, quantidade);
            }

            do {
                System.out.print("REPETIR OPERACAO? \n(S/N): ");
                op = input.nextLine().charAt(0);
                switch (op) {
                    case 'S':
                        break;
                    case 'N':
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (op != 'S' && op != 'N');

        } while (op != 'N');


    }
}