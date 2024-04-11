import java.util.Scanner;

public class ConvertTo {

    private final Scanner scanner; // Declaração do Scanner como atributo da classe

    public ConvertTo() {
        this.scanner = new Scanner(System.in); // Inicialização do Scanner no construtor
    }

    public void convertUSDtoARS(ConversionRateRecord response) {
        double taxaConversaoUSDparaARS = response.conversion_rates().getOrDefault("ARS", 0.0);
        double quantidadeUSD = getValor();
        double quantidadeARS = quantidadeUSD * taxaConversaoUSDparaARS;
        System.out.printf("%.2f USD é equivalente a %.2f ARS\n", quantidadeUSD, quantidadeARS);
    }

    public void convertARStoUSD(ConversionRateRecord response) {
        double taxaConversaoARSparaUSD = response.conversion_rates().getOrDefault("USD", 0.0)
                / response.conversion_rates().getOrDefault("ARS", 1.0);
        double quantidadeARS = getValor();
        double quantidadeUSD = quantidadeARS * taxaConversaoARSparaUSD;
        System.out.printf("%.2f ARS é equivalente a %.2f USD\n", quantidadeARS, quantidadeUSD);
    }

    public void convertUSDtoBRL(ConversionRateRecord response) {
        double taxaConversaoUSDparaBRL = response.conversion_rates().getOrDefault("BRL", 0.0);
        double quantidadeUSD = getValor();
        double quantidadeBRL = quantidadeUSD * taxaConversaoUSDparaBRL;
        System.out.printf("%.2f USD é equivalente a %.2f BRL\n", quantidadeUSD, quantidadeBRL);
    }

    public void convertBRLtoUSD(ConversionRateRecord response) {
        double taxaConversaoBRLparaUSD = 1 / response.conversion_rates().getOrDefault("BRL", 0.0);
        double quantidadeBRL = getValor();
        double quantidadeUSD = quantidadeBRL * taxaConversaoBRLparaUSD;
        System.out.printf("%.2f BRL é equivalente a %.2f USD\n", quantidadeBRL, quantidadeUSD);
    }

    public void convertUSDtoCOP(ConversionRateRecord response) {
        double taxaConversaoUSDparaCOP = response.conversion_rates().getOrDefault("COP", 0.0);
        double quantidadeUSD = getValor();
        double quantidadeCOP = quantidadeUSD * taxaConversaoUSDparaCOP;
        System.out.printf("%.2f USD é equivalente a %.2f COP\n", quantidadeUSD, quantidadeCOP);
    }

    public void convertCOPtoUSD(ConversionRateRecord response) {
        double taxaConversaoCOPparaUSD = 1 / response.conversion_rates().getOrDefault("COP", 0.0);
        double quantidadeCOP = getValor();
        double quantidadeUSD = quantidadeCOP * taxaConversaoCOPparaUSD;
        System.out.printf("%.2f COP é equivalente a %.2f USD\n", quantidadeCOP, quantidadeUSD);
    }

    private double getValor() {
        double valor = 0.0;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                System.out.println("Digite o valor da moeda:");
                valor = Double.parseDouble(scanner.nextLine());
                inputValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um valor numérico válido.");
            }
        }

        return valor;
    }

    public void closeScanner() {
        scanner.close(); 
    }
}
