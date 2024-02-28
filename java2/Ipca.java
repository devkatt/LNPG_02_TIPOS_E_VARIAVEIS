import java.util.Scanner;

public class Ipca {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int valor_mes;
            int valor_ano;
            double valor_ipca;
            int contador_input = 0;
            int[] array_mes = new int[100];
            int[] array_ano = new int[100];
            double[] array_valor_ipca = new double[100];
            int index_mes_maior = 0;
            int index_mes_menor = 0;
            int index_ano_maior = 0;
            int index_ano_menor = 0;
            double maior_ipca = 0;
            double menor_ipca = Double.MAX_VALUE;
            double soma = 0;
            double media = 0;

            while (true) {
                System.out.println("Digite o mês (fim para parar):");
                String entradaMes = scanner.next();
                if (entradaMes.equalsIgnoreCase("fim")) {
                    break;
                }
                valor_mes = Integer.parseInt(entradaMes);
                System.out.println("Digite o ano:");
                valor_ano = scanner.nextInt();
                System.out.println("Digite o valor do IPCA:");
                valor_ipca = scanner.nextDouble();
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

            System.out.printf("O menor valor de IPCA foi de %.2f, correspondente ao mês %d do ano %d\n", menor_ipca,
                    index_mes_menor, index_ano_menor);
            System.out.printf("O maior valor de IPCA foi de %.2f, correspondente ao mês %d do ano %d\n", maior_ipca,
                    index_mes_maior, index_ano_maior);
            System.out.printf("A média dos valores de IPCA foi de %.2f\n", media);
        }
    }
}
