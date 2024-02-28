import java.util.Scanner;

public class kidsplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Número de jogos vendidos por Catarina: ");
        int quantify_games_catarina_sold = scanner.nextInt();

        float price_game = 19.90f;
        float catarinas_base_payment = ((price_game / 2) * quantify_games_catarina_sold);

        int quantify_bonus_catarinas = quantify_games_catarina_sold / 15; // Corrigido: removido Math.floor
        float catarinas_bonus_payment = (price_game * quantify_bonus_catarinas) * 0.08f; // Corrigido: ajustado o cálculo do bônus

        System.out.printf("Valor arrecadado = %.2f%nBonus = %.2f%nPagamento Catarina = %.2f%n",
                price_game * quantify_games_catarina_sold,
                catarinas_bonus_payment,
                catarinas_base_payment + catarinas_bonus_payment);

        scanner.close();
    }
}
