import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Produtos {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Produto ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "nome VARCHAR(100), "
                    + "preco DOUBLE)");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserirProduto(String nome, double preco) throws SQLException {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Produto (nome, preco) VALUES (?, ?)")) {
            insertStatement.setString(1, nome);
            insertStatement.setDouble(2, preco);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Produto: " + e.getMessage());
        }
    }

    public void lerProduto(String nome) throws SQLException {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Produto WHERE nome = ?")) {
            selectStatement.setString(1, nome);
            try (ResultSet rs = selectStatement.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Preço: " + rs.getDouble("preco"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar Produto: " + e.getMessage());
        }
    }

    public void deletarProduto(String nome) throws SQLException {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Produto WHERE nome = ?")) {
            deleteStatement.setString(1, nome);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Produto: " + e.getMessage());
        }
    }
}