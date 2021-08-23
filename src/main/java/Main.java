import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA - SISTEMA DE CONTROLE DE ESTOQUE");

        Scanner menu = new Scanner(System.in);
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

            opcao = menu.nextInt();

            if (opcao == 0) {
                System.out.print("\nAté logo!");
                menu.close();
            }

            switch (opcao) {
                case 1:
                    produto();
                    break;
                case 2:
                    System.out.print("\nMOVIMENTAÇÃO\n");
                    break;
                case 3:
                    System.out.print("\nREAUSTE DE PREÇOS\n");
                    break;
                case 4:
                    System.out.println("\nRELATÓRIOS");
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
                    System.out.println("Inclusão de produto");
                    break;
                case 2:
                    System.out.println("Alteração de Produto");
                    break;
                case 3:
                    System.out.println("Exclusão de produtos");
                    break;
                case 4:
                    System.out.println("Relatório de produtos");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }
}