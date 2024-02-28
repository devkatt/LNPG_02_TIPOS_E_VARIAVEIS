#include <stdio.h>

int main() {
    int quantify_games_catarina_sold;
    printf("Número de jogos vendidos por Catarina: ");
    scanf("%d", &quantify_games_catarina_sold);

    float price_game = 19.90;
    float catarinas_base_payment = (price_game / 2) * quantify_games_catarina_sold;

    int quantify_bonus_catarinas = quantify_games_catarina_sold / 15;
    float catarinas_bonus_payment = (price_game * quantify_bonus_catarinas) * 0.08;

    printf("Valor arrecadado = %.2f\nBonus = %.2f\nPagamento Catarina = %.2f\n",
           price_game * quantify_games_catarina_sold,
           catarinas_bonus_payment,
           catarinas_base_payment + catarinas_bonus_payment);

    return 0;
}
