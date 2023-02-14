import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double distance = scanner.nextDouble(); // The distance between two cities (miles)
        double travelTime = scanner.nextDouble(); // the travel time by bus (hours)
        System.out.println(distance / travelTime);
    }
}