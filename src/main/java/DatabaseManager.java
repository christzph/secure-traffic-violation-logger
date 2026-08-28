import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    public static void salvarInfracao(Infracao infracao) {
        String sql = "INSERT INTO infracoes (placa, velocidade, limite, data_hora) VALUES (?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, infracao.getPlaca());
            pstmt.setDouble(2, infracao.getVelocidadeRegistrada());
            pstmt.setDouble(3, infracao.getLimiteVia());
            pstmt.setString(4, infracao.getDataHoraString());

            pstmt.executeUpdate();
            System.out.println("[DB-SECURE] Infração da placa " + infracao.getPlaca() + " persistida com segurança (PreparedStatement).");

        } catch (SQLException | NullPointerException e) {
            System.out.println("[ERRO SQL] Falha ao salvar infração: " + e.getMessage());
        }
    }
}