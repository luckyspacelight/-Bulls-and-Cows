package bullscows;

public class Grader {

    private String digitsTry;
    private String secretNumber;

    public Grader(String digitsTry, String secretNumber) {
        this.digitsTry = digitsTry;
        this.secretNumber = secretNumber;
    }

    public String determineTheGrade() {

        //Tries array
        String[] arNT = this.digitsTry.split("");

        // Secret Number array
        String[] arSN = this.secretNumber.split("");

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
        return String.format("Grade: %d bull(s) and %d cow(s). The secret code is %s.",
                bullCounter, cowsCounter, this.secretNumber);
    }

}
