import java.time.LocalDateTime;

public class Infracao {
    private String placa;
    private double velocidadeRegistrada;
    private double limiteVia;
    private LocalDateTime dataHora;

    public Infracao(String placa, double velocidadeRegistrada, double limiteVia) {
        this.placa = placa;
        this.velocidadeRegistrada = velocidadeRegistrada;
        this.limiteVia = limiteVia;
        this.dataHora = LocalDateTime.now();
    }

    public String getPlaca() { return placa; }
    public double getVelocidadeRegistrada() { return velocidadeRegistrada; }
    public double getLimiteVia() { return limiteVia; }
    public String getDataHoraString() { return dataHora.toString(); }

    @Override
    public String toString() {
        return String.format("INFRAÇÃO REGISTRADA -> Placa: %s | Velocidade: %.1f km/h (Limite: %.1f km/h) | %s",
                placa, velocidadeRegistrada, limiteVia, dataHora);
    }
}