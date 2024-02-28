#include <stdio.h>
#include <math.h>

double getPI(int length);

int main() {
    int length;
    printf("Informe o número de termos: ");
    scanf("%d", &length);

    printf("%.5f\n", getPI(length));

    return 0;
}

double getPI(int length) {
    double agg = 0;

    for (int i = 0; i < length; i++) {
        int value = (i * 2) + 1;
        double seq = 1.0 / pow(value, 3);

        if (i % 2 == 0) {
            agg += seq;
        } else {
            agg -= seq;
        }
    }

    return cbrt(32 * agg);
}
