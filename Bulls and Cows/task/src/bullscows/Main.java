package bullscows;

public class Main {

    // This is the Secret Number
    public static String SECRET_NUMBER;

    public static void main(String[] args) {

        // The secret code has not yet been guessed
        boolean isUnsolvedCode = true;

        // Ask for the length of the secret code
        int numDigits = Helper.defineSecretCodeLength();


        // Input the number of possible symbols in the code
        int numSymbols = Helper.defineNumSymbols();

        String strMessage = "";
        if (numDigits > 36 || numSymbols > 36) {
            strMessage = "Error: maximum number of possible symbols in the code is 36 (0-9, a-z)";
            System.out.println(strMessage);
        } else if (numDigits <= 0) {
            strMessage = "Error: The secret code must contain at least one valid symbol.";
            System.out.println(strMessage);
        } else if (numDigits > numSymbols) {
            strMessage = String.format("Error: it's not possible to generate " +
                    "a code with a length of %d with %d unique symbols.", numDigits, numSymbols);
            System.out.println(strMessage);
        } else {
            String[] arSN = Helper.generateSecretNumber(numDigits, numSymbols);
            SECRET_NUMBER = arSN[0];
            System.out.println(SECRET_NUMBER);
            System.out.println(arSN[1]); // Print the confirmation: the secret is prepared.

            System.out.println("Okay, let's start a game!");
            int turnCounter = 1;
            while (isUnsolvedCode) {
                String tryNum = Helper.guessTheNumber(turnCounter);
                if (tryNum.length() != numDigits) {
                    strMessage =  "\"" + tryNum + "\" isn't a valid number.";
                    System.out.println(strMessage);
                    return;
                }
                Grader grader = new Grader(tryNum);
                String grade = grader.determineTheGrade();
                System.out.println(grade);
                isUnsolvedCode = grader.isUnsolvedCode();
                turnCounter++;
            }
        }
    }
}