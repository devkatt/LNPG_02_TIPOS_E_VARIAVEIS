import java.util.Scanner;

public class Controle {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Quantos passageiros tem na fila? ");
            int numberPassenger = scan.nextInt();
            scan.nextLine(); // Consumir a quebra de linha pendente após nextInt()

            // Passenger data
            String rg = "nao possui"; // String ou "Nao possui"
            String pass = "nao possui"; // String ou "Nao possui"
            String rgDate; // "DD/MM/AAAA"
            String passDate; // "DD/MM/AAAA"
            String seat; // "A12"

            for (int i = 0; i < numberPassenger; i++) {
                System.out.print("\nDigite RG ou 'Nao possui': ");
                rg = scan.nextLine().toLowerCase();
                System.out.print("Digite seu Passagem ou 'Nao possui': ");
                pass = scan.nextLine().toLowerCase();
                System.out.print("Digite a data de nascimento do seu RG: ");
                rgDate = scan.nextLine();
                System.out.print("Digite a data de nascimento do seu Passaporte: ");
                passDate = scan.nextLine();
                System.out.print("Digite seu assento no Avião: ");
                seat = scan.nextLine();

                if (rg.equals("nao possui")) {
                    System.out.printf("\nA saída é nessa direção passageiro n°%s ", i + 1);
                } else if (pass.equals("nao possui")) {
                    System.out.println("A recepção é nessa direção");
                } else if (!rgDate.equals(passDate)) {
                    System.out.println("190");
                } else {
                    System.out.printf("\nSeu assento é %s, tenha um bom dia", seat);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
