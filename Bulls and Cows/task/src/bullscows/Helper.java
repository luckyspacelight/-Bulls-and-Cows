package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Helper {

    public static String generateSecretNumber() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public static String generateSecretNumber(int numDigits) {

        // Secret number counter setup
        int numSNCount = numDigits;

        if (numDigits > 10) {
            return "Error: can't generate a secret number with a length of 11 " +
                    "because there aren't enough unique digits.";
        } else {

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
    }

    public static String guessTheNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
