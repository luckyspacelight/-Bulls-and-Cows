package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Helper {

    public static String[] generateSecretNumber(int numDigits, int numTotalSymbols) {

        Random random = new Random();

        // Secret number counter setup
        int numSNCount = numDigits;

        // Secret number setup
        StringBuilder strSecretNumber = new StringBuilder();

        while (numSNCount > 0) {

            int randomValue = random.nextInt(numTotalSymbols);
            char character;
            if (randomValue < 10) {
                character = (char) (randomValue + '0');
            } else {
                character = (char) (randomValue - 10 + 'a');
            }

            if (!strSecretNumber.toString().contains(String.valueOf(character))) {
                strSecretNumber.append(character);
                numSNCount--;
            }

        }

        String message = String.format("The secret is prepared: %s %s.",
                printAsterisks(numDigits), printRanges(numTotalSymbols));

        String[] arSecretNumber = new String[2];
        arSecretNumber[0] = strSecretNumber.toString();
        arSecretNumber[1] = message;
        return arSecretNumber;
    }

    public static String generateSNComplex(int numDigits) {

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
        System.out.println("Input the length of the secret code:");
        String tmp = scanner.next();
        if (tmp.matches("\\d+")) {
            return Integer.parseInt(tmp);
        } else {
            System.out.println("Error: the secret code must be numeric.");
            System.exit(0);
        }
        return -1;
    }

    public static int defineNumSymbols() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of possible symbols in the code:");
        return scanner.nextInt();
    }

    public static String printAsterisks(int numDigits){
        String hiddenCode = "";
        for (int i = 0; i < numDigits; i++) {
            hiddenCode += "*";
        }
        return hiddenCode;
    }

    public static String printRanges(int numTotalSymbols) {
        String ranges = "";

        if (numTotalSymbols <= 10) {
            ranges = String.format("(0-%s)", (char) (numTotalSymbols - 1 + 48));
        } else {
            ranges = String.format("(0-9) (a-%s)", (char) (numTotalSymbols - 1 - 10 + 97));
        }

        return ranges;
    }



}
