package bullscows;

public class Grader {

    private final String digitsTry;
    private boolean isUnsolvedCode;

    public Grader(String digitsTry) {
        this.digitsTry = digitsTry;
        this.isUnsolvedCode = true;
    }

    public boolean isUnsolvedCode() {
        return isUnsolvedCode;
    }

    public String determineTheGrade() {

        //Tries array
        String[] arNT = this.digitsTry.split("");

        // Secret Number array
        String[] arSN = Main.SECRET_NUMBER.split("");

        int cowsCounter = 0;
        int bullCounter = 0;

        for (int i = 0; i < arNT.length; i++) {
            for (int j = 0; j < arSN.length; j++) {

                if (arNT[i].equals(arSN[j])) {
                    if (i == j) {
                        bullCounter++;
                    } else {
                        cowsCounter++;
                    }
                }

            }
        }

        this.isUnsolvedCode = (bullCounter != arSN.length);

        String strBullPlural = bullCounter == 1 ? "" : "s";
        String strCowPlural = cowsCounter == 1 ? "" : "s";
        String grade = String.format("Grade: %d bull%s and %d cow%s. The secret code is %s.",
                bullCounter, strBullPlural, cowsCounter, strCowPlural, Main.SECRET_NUMBER);


        if (this.isUnsolvedCode == false) {
            StringBuilder sb = new StringBuilder(grade);
            sb.append("\nCongratulations! You guessed the secret code.");
            grade = sb.toString();
        }

        return grade;
    }

}
