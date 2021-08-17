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

            if (opcao == 4) {
                System.out.print("\nAté logo!");
                menu.close();
            }

            switch (opcao) {
                case 1:
                    System.out.print("\nCADASTRO DE PRODUTOS");
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
        } while (opcao != 4);

    }
}