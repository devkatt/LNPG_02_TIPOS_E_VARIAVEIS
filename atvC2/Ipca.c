#include <stdio.h>

int main() {
    int valor_mes;
    int valor_ano;
    double valor_ipca;
    int contador_input = 0;
    int array_mes[100];
    int array_ano[100];
    double array_valor_ipca[100];
    int index_mes_maior = 0;
    int index_mes_menor = 0;
    int index_ano_maior = 0;
    int index_ano_menor = 0;
    double maior_ipca = 0;
    double menor_ipca = __DBL_MAX__;
    double soma = 0;
    double media = 0;

    while (1) {
        printf("Digite o mês (fim para parar): ");
        char entradaMes[10];
        scanf("%s", entradaMes);
        if (strcmp(entradaMes, "fim") == 0) {
            break;
        }
        valor_mes = atoi(entradaMes);
        printf("Digite o ano: ");
        scanf("%d", &valor_ano);
        printf("Digite o valor do IPCA: ");
        scanf("%lf", &valor_ipca);
        array_ano[contador_input] = valor_ano;
        array_mes[contador_input] = valor_mes;
        array_valor_ipca[contador_input] = valor_ipca;
        contador_input++;
    }

    for (int i = 0; i < contador_input; i++) {
        if (maior_ipca < array_valor_ipca[i]) {
            maior_ipca = array_valor_ipca[i];
            index_mes_maior = array_mes[i];
            index_ano_maior = array_ano[i];
        }
        if (menor_ipca > array_valor_ipca[i]) {
            menor_ipca = array_valor_ipca[i];
            index_mes_menor = array_mes[i];
            index_ano_menor = array_ano[i];
        }
    }

    for (int i = 0; i < contador_input; i++) {
        soma += array_valor_ipca[i];
    }
    media = soma / contador_input;

    printf("O menor valor de IPCA foi de %.2f, correspondente ao mês %d do ano %d\n", menor_ipca,
           index_mes_menor, index_ano_menor);
    printf("O maior valor de IPCA foi de %.2f, correspondente ao mês %d do ano %d\n", maior_ipca,
           index_mes_maior, index_ano_maior);
    printf("A média dos valores de IPCA foi de %.2f\n", media);

    return 0;
}
