import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("*******************************");
        System.out.println("     Conversor de Moeda");
        System.out.println("-------------------------------");
        System.out.println("(1) Dólar ==> Peso Argentino");
        System.out.println("(2) Peso ==> Dólar");
        System.out.println("(3) Dólar ==> Real Brasileiro");
        System.out.println("(4) Real Brasileiro ==> Dólar");
        System.out.println("(5) Dólar ==> Peso Colombiano");
        System.out.println("(6) Peso Colombiano ==> Dólar");
        System.out.println("(7) Sair");
        System.out.println("Escolha uma opção válida:");
        System.out.println("-------------------------------");
    }

    public int getUserChoice() {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 7) {
                    break;
                } else {
                    System.out.println("Por favor, escolha uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número.");
            }
        }
        return choice;
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
