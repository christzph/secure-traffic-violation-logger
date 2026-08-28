public class Radar {
    private String localizacao;
    private double limiteVelocidade;
    private final double TOLERANCIA = 7.0;

    public Radar(String localizacao, double limiteVelocidade) {
        this.localizacao = localizacao;
        this.limiteVelocidade = limiteVelocidade;
    }

    public Infracao processarVeiculo(String placa, double velocidade) {
        if (velocidade > (limiteVelocidade + TOLERANCIA)) {
            System.out.println("[ALERTA] Veículo acima do limite na " + localizacao);
            return new Infracao(placa, velocidade, limiteVelocidade);
        }
        System.out.println("[OK] Veículo regular na " + localizacao + ": " + placa);
        return null;
    }
}