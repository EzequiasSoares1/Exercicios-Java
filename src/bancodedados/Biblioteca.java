package bancodedados;
import java.sql.*;

public class Biblioteca {
    private static Connection myConnection;
    private static PreparedStatement statement;

    public static void main(String[] args) throws SQLException, InterruptedException {
        myConnection = ConexaoDB.getConnection();

        cadastrarTabela();

        inserirBiblioteca(1,"O Alquimista", "Paulo Coelho", 1988);
        inserirBiblioteca(2,"habitos hatomicos", "JOSE", 2011);

        imprimirTabela();
        atualizarBiblioteca(1, "O Alquimista", "Paulo Coelho", 1990);

        Thread.sleep(1000);
        imprimirTabela();

        deletarBiblioteca(2);
        Thread.sleep(1000);


        imprimirTabela();

        myConnection.close();
    }

    public static void inserirBiblioteca(int id, String titulo, String autor, int anoPublicacao) {
        String sql = "INSERT INTO livro (id,titulo, autor, ano_publicacao) VALUES (?, ?, ?, ?)";

        try{
            statement = myConnection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, titulo);
            statement.setString(3, autor);
            statement.setInt(4, anoPublicacao);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void atualizarBiblioteca(int id, String titulo, String autor, int anoPublicacao) {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, ano_publicacao = ? WHERE id = ?";

        try{
            statement = myConnection.prepareStatement(sql);
            statement.setString(1, titulo);
            statement.setString(2, autor);
            statement.setInt(3, anoPublicacao);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deletarBiblioteca(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";

        try{
            statement = myConnection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void cadastrarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS livro(" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "titulo VARCHAR(100) NOT NULL, " +
                "autor VARCHAR(100) NOT NULL, " +
                "ano_publicacao INT NOT NULL" +
                ")";

        try
        {
            statement = myConnection.prepareStatement(sql);
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void imprimirTabela(){
        try {
            ResultSet resultSet = statement.executeQuery("select * from livro");
            while (resultSet.next()) {
                System.out.print("ID: "+resultSet.getInt("id"));
                System.out.print(" titulo: "+resultSet.getString("titulo"));
                System.out.print(" autor: "+resultSet.getString("autor"));
                System.out.print(" ano_publicacao: "+resultSet.getInt("ano_publicacao"));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n");
    }

}
