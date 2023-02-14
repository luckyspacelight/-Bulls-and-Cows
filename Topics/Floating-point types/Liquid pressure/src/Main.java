import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double d = scanner.nextDouble();
        double h = scanner.nextDouble();
        final double g = 9.8;

        double p = d * h * g;
        System.out.println(p);

    }
}