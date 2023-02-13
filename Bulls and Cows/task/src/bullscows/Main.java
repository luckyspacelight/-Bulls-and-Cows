package bullscows;

public class Main {

    // This is the Secret Number
    public static String SECRET_NUMBER;

    public static void main(String[] args) {

        // The secret code has not yet been guessed
        boolean isUnsolvedCode = true;

        // Ask for the length of the secret code
        int numDigits = Helper.defineSecretCodeLength();

        if (numDigits > 10) {
            String strMessage = "Error: can't generate a secret number with a length of 11 " +
                    "because there aren't enough unique digits.";
            System.out.println(strMessage);
        } else {
            SECRET_NUMBER = Helper.generateSecretNumber(numDigits);
            System.out.println("Okay, let's start a game!");
            int turnCounter = 1;
            while (isUnsolvedCode) {
                String tryNum = Helper.guessTheNumber(turnCounter);
                Grader grader = new Grader(tryNum);
                String grade = grader.determineTheGrade();
                System.out.println(grade);
                isUnsolvedCode = grader.isUnsolvedCode();
                turnCounter++;
            }
        }
    }
}