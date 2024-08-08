import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            cadastro.imprimirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastro.adicionarProduto();
                    break;
                case 2:
                    cadastro.deletarProduto();
                    break;
                case 3:
                    cadastro.lerProduto();
                    break;
                case 4:
                    cadastro.adicionarFuncionario();
                    break;
                case 5:
                    cadastro.lerFuncionario();
                    break;
                case 6:
                    cadastro.deletarFuncionario();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}