public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistema Central de Monitoramento de Tráfego ---");

        DatabaseManager.inicializarBanco();
        System.out.println("---------------------------------------------------");

        Radar radarCuritiba = new Radar("Avenida Visconde de Guarapuava", 60.0);

        radarCuritiba.processarVeiculo("ABC-1234", 55.0); // Passou no limite

        Infracao inf = radarCuritiba.processarVeiculo("HACK-999", 82.5);

        if (inf != null) {
            System.out.println(inf.toString());

            DatabaseManager.salvarInfracao(inf);
        }

        DatabaseManager.exibirRelatorioInfracoes();
    }
}