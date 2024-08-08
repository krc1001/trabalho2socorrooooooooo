import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Funcionarios {




    public static void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Funcionario ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "nome VARCHAR(100), "
                    + "telefone VARCHAR(15), "
                    + "dataEntrada DATE)");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }


    public void lerFuncionario(String nomeQuery) throws SQLException {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Funcionario WHERE nome = ?")) {
            selectStatement.setString(1, nomeQuery);
            try (ResultSet rs = selectStatement.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Telefone: " + rs.getString("telefone"));
                    System.out.println("Data de Entrada: " + rs.getDate("dataEntrada"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar Funcionario: " + e.getMessage());
        }
    }

    public void deleteFuncionario(String nome) throws SQLException {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Funcionario WHERE nome = ?")) {
            deleteStatement.setString(1, nome);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Funcionario: " + e.getMessage());
        }
    }


    public void insertClient(String nome) {
    }
}