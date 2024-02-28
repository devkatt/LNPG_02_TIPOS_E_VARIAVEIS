import java.util.Scanner;

public class ValorPI {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Informe o número de termos: ");
            final int length = scanner.nextInt();

            System.out.println(String.format("%.5f", getPI(length)));
        }
    }

    public static double getPI(int length) {
        double agg = 0;

        for (int i = 0; i < length; i++) {
            final int value = (i * 2) + 1;
            final double seq = 1.0 / Math.pow(value, 3);

            if (i % 2 == 0) {
                agg += seq;
            } else {
                agg -= seq;
            }
        }

        return Math.cbrt(32 * agg);
    }
}
