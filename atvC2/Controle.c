#include <stdio.h>
#include <string.h>

int main() {
    int numberPassenger;
    printf("Quantos passageiros tem na fila? ");
    scanf("%d", &numberPassenger);
    getchar(); // Consumir o caractere de quebra de linha pendente após a leitura do número

    // Passenger data
    char rg[20] = "nao possui"; // String ou "Nao possui"
    char pass[20] = "nao possui"; // String ou "Nao possui"
    char rgDate[12]; // "DD/MM/AAAA"
    char passDate[12]; // "DD/MM/AAAA"
    char seat[4]; // "A12"

    for (int i = 0; i < numberPassenger; i++) {
        printf("\nDigite RG ou 'Nao possui': ");
        fgets(rg, sizeof(rg), stdin);
        rg[strcspn(rg, "\n")] = '\0'; // Remover a quebra de linha

        printf("Digite seu Passagem ou 'Nao possui': ");
        fgets(pass, sizeof(pass), stdin);
        pass[strcspn(pass, "\n")] = '\0'; // Remover a quebra de linha

        printf("Digite a data de nascimento do seu RG: ");
        fgets(rgDate, sizeof(rgDate), stdin);
        rgDate[strcspn(rgDate, "\n")] = '\0'; // Remover a quebra de linha

        printf("Digite a data de nascimento do seu Passaporte: ");
        fgets(passDate, sizeof(passDate), stdin);
        passDate[strcspn(passDate, "\n")] = '\0'; // Remover a quebra de linha

        printf("Digite seu assento no Avião: ");
        fgets(seat, sizeof(seat), stdin);
        seat[strcspn(seat, "\n")] = '\0'; // Remover a quebra de linha

        if (strcmp(rg, "nao possui") == 0) {
            printf("\nA saída é nessa direção passageiro n°%d\n", i + 1);
        } else if (strcmp(pass, "nao possui") == 0) {
            printf("A recepção é nessa direção\n");
        } else if (strcmp(rgDate, passDate) != 0) {
            printf("190\n");
        } else {
            printf("\nSeu assento é %s, tenha um bom dia\n", seat);
        }
    }

    return 0;
}
