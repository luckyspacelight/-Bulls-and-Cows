package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Helper {

    public static String generateSecretNumber(int numDigits) {

        // Secret number counter setup
        int numSNCount = numDigits;

        // Secret number setup
        StringBuilder strSecretNumber = new StringBuilder();

        while (numSNCount > 0) {
            String strPRN = String.valueOf(System.nanoTime());
            for (int i = strPRN.length() - 1; i >= 0 && numSNCount > 0; i--) {
                if (numSNCount == numDigits && strPRN.charAt(i) == '0') {
                    continue;
                }
                if (!strSecretNumber.toString().contains(String.valueOf(strPRN.charAt(i)))) {
                    strSecretNumber.append(strPRN.charAt(i));
                    numSNCount--;
                }
            }
        }
        return strSecretNumber.toString();

    }

    public static String guessTheNumber(int turnCounter) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Turn %d:%n", turnCounter);
        return scanner.nextLine();
    }
    public static int defineSecretCodeLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        return scanner.nextInt();
    }

}
