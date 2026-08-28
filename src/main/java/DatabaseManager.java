import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:transito.db";

    public static Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(URL);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("[ERRO DB] Falha ao conectar: " + e.getMessage());
            return null;
        }
    }

    public static void inicializarBanco() {
        String sql = "CREATE TABLE IF NOT EXISTS infracoes ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "placa TEXT NOT NULL, "
                + "velocidade REAL NOT NULL, "
                + "limite REAL NOT NULL, "
                + "data_hora TEXT NOT NULL"
                + ");";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("[DB] Banco de dados inicializado. Tabela 'infracoes' estruturada com sucesso.");

        } catch (SQLException e) {
            System.out.println("[ERRO SQL] Falha ao inicializar banco: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("[ERRO] Conexão com o banco falhou, abortando inicialização.");
        }
    }
}