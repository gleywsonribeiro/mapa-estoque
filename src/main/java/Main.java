import modelo.Estoque;
import modelo.Produto;

import java.util.Locale;
import java.util.NoSuchElementException;
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
                    reajuste();
                    break;
                case 4:
                    relatorio();
                case 0:
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
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
            System.out.print("| 1 - INCLUSÃO                |\n");
            System.out.print("| 2 - ALTERAÇÃO               |\n");
            System.out.print("| 3 - CONSULTA                |\n");
            System.out.print("| 4 - EXCLUSÃO                |\n");
            System.out.print("| 0 - RETORNAR                |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    inclusao();
                    break;
                case 2:
                    alteracao();
                    break;
                case 3:
                    consulta();
                    break;
                case 4:
                    exclusao();
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
            System.out.print("##---MOVIMENTAÇÃO----##\n");
            System.out.print("|----------------------|\n");
            System.out.print("| 1 - ENTRADA          |\n");
            System.out.print("| 2 - SAÍDA            |\n");
            System.out.print("| 0 - RETORNAR         |\n");
            System.out.print("|----------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    entrada();
                    break;
                case 2:
                    saida();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private static void inclusao() {
        char op = 'n';
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("##---INCLUSÃO DE PRODUTO----##\n");
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
                System.out.print("CONFIRMA INCLUSÃO? \n(s/n): ");
                sn = input.next().charAt(0);
                switch (sn) {
                    case 's':
                        try {
                            Produto produto = new Produto(nome, preco, unidade, quantidade);
                            estoque.adiciona(produto);
                            System.out.println("Salvo com sucesso!");
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
                System.out.print("REPETIR OPERAÇÃO? \n(s/n): ");
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

    private static void alteracao() {
        char op = 's';

        do {
            Scanner entrada = new Scanner(System.in);
            try {
                System.out.print("##----ALTERAÇÃO DE PRODUTO----##\n");
                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                Produto produtoAtualizado = estoque.consulta(nome);

                System.out.println(produtoAtualizado);

                System.out.print("Preço: ");
                double preco = entrada.nextDouble();

                System.out.print("Unidade: ");
                entrada.nextLine();
                String unidade = entrada.nextLine();

                char sn = 'n';
                do {
                    Scanner input = new Scanner(System.in);
                    System.out.print("CONFIRMA ALTERAÇÃO? \n(s/n): ");
                    sn = input.next().charAt(0);
                    switch (sn) {
                        case 's':
                            produtoAtualizado.setPreco(preco);
                            produtoAtualizado.setUnidade(unidade);
                            estoque.atualiza(produtoAtualizado);
                            System.out.println("Produto atualizado com sucesso!");
                            break;
                        case 'n':
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                } while (sn != 's' && sn != 'n');
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.print("REPETIR OPERAÇÃO? \n(s/n): ");
                op = entrada.next().charAt(0);
                switch (op) {
                    case 's':
                        break;
                    case 'n':
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (op != 's' && op != 'n');


        } while (op == 's');
    }

    private static void consulta() {
        char op = 'n';
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.print("##----CONSULTA DE PRODUTO----##\n");
                System.out.print("Nome: ");
                String nome = input.nextLine();

                Produto produtoAtualizado = estoque.consulta(nome);

                System.out.println(produtoAtualizado);

            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.print("REPETIR OPERAÇÃO? \n(s/n): ");
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

    private static void exclusao() {
        char op = 's';

        do {
            Scanner entrada = new Scanner(System.in);
            try {
                System.out.print("##----EXCLUSÃO DE PRODUTO----##\n");
                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                Produto produtoAtualizado = estoque.consulta(nome);

                System.out.println(produtoAtualizado);


                char sn = 'n';
                do {
                    Scanner input = new Scanner(System.in);
                    System.out.print("CONFIRMA EXCLUSÃO? \n(s/n): ");
                    sn = input.next().charAt(0);
                    switch (sn) {
                        case 's':
                            estoque.remove(produtoAtualizado);
                            System.out.println("Produto removido com sucesso!");
                            break;
                        case 'n':
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                } while (sn != 's' && sn != 'n');

            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.print("REPETIR OPERAÇÃO? \n(s/n): ");
                op = entrada.next().charAt(0);
                switch (op) {
                    case 's':
                        break;
                    case 'n':
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (op != 's' && op != 'n');

        } while (op == 's');
    }

    private static void entrada() {
        char op = 's';

        do {
            Scanner entrada = new Scanner(System.in);
            try {
                System.out.print("##----ENTRADA DE PRODUTO----##\n");
                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                Produto produto = estoque.consulta(nome);

                System.out.println(produto);


                System.out.print("Entrada (qtd): ");
                int quantidade = entrada.nextInt();
                System.out.println("Saldo Final: " + (produto.getQuantidadeEstoque() + quantidade));

                char sn = 'n';
                do {
                    Scanner input = new Scanner(System.in);
                    System.out.print("CONFIRMA MOVIMENTAÇÃO? \n(s/n): ");
                    sn = input.next().charAt(0);
                    switch (sn) {
                        case 's':
                            produto.entrada(quantidade);
                            estoque.atualiza(produto);
                            System.out.println("Movimentação salva om sucesso!");
                            break;
                        case 'n':
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                } while (sn != 's' && sn != 'n');
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.print("REPETIR OPERAÇÃO? \n(s/n): ");
                op = entrada.next().charAt(0);
                switch (op) {
                    case 's':
                        break;
                    case 'n':
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (op != 's' && op != 'n');


        } while (op == 's');
    }

    private static void saida() {
        char op = 's';

        do {
            Scanner entrada = new Scanner(System.in);
            try {
                System.out.print("##----SAÍDA DE PRODUTO----##\n");
                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                Produto produto = estoque.consulta(nome);

                System.out.println(produto);


                System.out.print("Saída (qtd): ");
                int quantidade = entrada.nextInt();
                System.out.println("Saldo Final: " + (produto.getQuantidadeEstoque() - quantidade));

                char sn = 'n';
                do {
                    Scanner input = new Scanner(System.in);
                    System.out.print("CONFIRMA MOVIMENTAÇÃO? \n(s/n): ");
                    sn = input.next().charAt(0);
                    switch (sn) {
                        case 's':
                            produto.baixa(quantidade);
                            estoque.atualiza(produto);
                            System.out.println("Movimentação salva om sucesso!");
                            break;
                        case 'n':
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                } while (sn != 's' && sn != 'n');
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.print("REPETIR OPERAÇÃO? \n(s/n): ");
                op = entrada.next().charAt(0);
                switch (op) {
                    case 's':
                        break;
                    case 'n':
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (op != 's' && op != 'n');


        } while (op == 's');
    }

    private static void reajuste() {
        char op = 's';

        do {
            Scanner entrada = new Scanner(System.in);
            try {
                System.out.print("##----REAJUSTE DE PREÇO----##\n");

                double taxa;
                do {
                    System.out.print("Taxa de Reajuste (Ex: 15% = 0.15): ");
                    taxa = entrada.nextDouble();
                    if (taxa > 1 || taxa <= 0) {
                        System.out.println("Taxa inválida!");
                    }
                } while (taxa > 1 || taxa <= 0);

                char sn = 'n';
                do {
                    Scanner input = new Scanner(System.in);
                    System.out.print("CONFIRMA REAJUSTE DE PRECO de " + (taxa * 100) + "%? \n(s/n): ");
                    sn = input.next().charAt(0);
                    switch (sn) {
                        case 's':
                            estoque.reajuste(taxa);
                            System.out.println("Reajuste realizado com sucesso!");
                            break;
                        case 'n':
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                } while (sn != 's' && sn != 'n');
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.print("REPETIR OPERAÇÃO? \n(s/n): ");
                op = entrada.next().charAt(0);
                switch (op) {
                    case 's':
                        break;
                    case 'n':
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (op != 's' && op != 'n');


        } while (op == 's');
    }

    private static void relatorio() {
        char opcao = 'n';
        do {
            estoque.printRelatorio();
            Scanner input = new Scanner(System.in);

            do {
                System.out.print("Imprimir novamente?(s/n): ");
                opcao = input.next().charAt(0);
                switch (opcao) {
                    case 's':
                        break;
                    case 'n':
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (opcao != 's' && opcao != 'n');
        } while (opcao == 's');
    }

}