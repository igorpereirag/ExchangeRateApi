public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        CurrencyConverter converter = new CurrencyConverter();
        String apikey = "sua-chave-api-aqui";

        try {
            while (true) {
                menu.showMenu();
                int choice = menu.getUserChoice();

                if (choice == 7) {
                    System.out.println("Obrigado, Até logo!");
                    break;
                }

                converter.convertCurrency(choice, apikey);
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            menu.closeScanner();
        }
    }
}
