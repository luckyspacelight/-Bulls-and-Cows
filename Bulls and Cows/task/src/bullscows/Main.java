package bullscows;

public class Main {

    // This is the Secret Number
    public static final String SECRET_NUMBER = Helper.generateSecretNumber();

    public static void main(String[] args) {

        // The secret code has not yet been guessed
        boolean isUnsolvedCode = true;

        //System.out.println(SECRET_NUMBER);
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
