import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    public static Scanner scanner = new Scanner(System.in);
    BancoDeDados bancoDeDados = new BancoDeDados();
    Produtos produtos = new Produtos();
    Funcionarios funcionarios = new Funcionarios();

    void adicionarProduto() {
        bancoDeDados.connect();
        produtos.createTable();

        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha

        try {
            produtos.inserirProduto(nome, preco);
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }

        bancoDeDados.close();
    }

    void lerProduto() {
        bancoDeDados.connect();

        System.out.println("Digite o nome do produto a consultar:");
        String nome = scanner.nextLine();

        try {
            produtos.lerProduto(nome);
        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
        }

        bancoDeDados.close();
    }

    void deletarProduto() {
        bancoDeDados.connect();

        System.out.println("Digite o nome do produto a deletar:");
        String nome = scanner.nextLine();

        try {
            produtos.deletarProduto(nome);
            System.out.println("Produto deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }

        bancoDeDados.close();
    }



    void lerFuncionario() {
        bancoDeDados.connect();

        System.out.println("Digite o nome do funcionário a consultar:");
        String nome = scanner.nextLine();

        try {
            funcionarios.lerFuncionario(nome);
        } catch (SQLException e) {
            System.out.println("Erro ao consultar funcionário: " + e.getMessage());
        }

        bancoDeDados.close();
    }

    void deletarFuncionario() {
        bancoDeDados.connect();

        System.out.println("Digite o nome do funcionário a deletar:");
        String nome = scanner.nextLine();

        try {
            funcionarios.deleteFuncionario(nome);
            System.out.println("Funcionário deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionário: " + e.getMessage());
        }

        bancoDeDados.close();
    }

    void imprimirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1- Inserir produto");
        System.out.println("2- Deletar produto");
        System.out.println("3- Consultar produto");
        System.out.println("4- Inserir funcionário");
        System.out.println("5- Consultar");
    }

    public void adicionarFuncionario() {
        {
            try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO funcionarios (Nome) (Telefone) (Data) VALUES (?)")) {
                String nome = "nome";
                String telefone = "telefone";
                String data = "data";

                insertStatement.setString(1, nome);
                insertStatement.setString(1, telefone);
                insertStatement.setString(1, data);
                insertStatement.executeUpdate();
                BancoDeDados.connection.commit();
                System.out.println("Funcionario inserido.");
            } catch (SQLException e) {
                System.out.println("Erro ao inserir Funcionario: " + e.getMessage());
            }
        }
    }
}