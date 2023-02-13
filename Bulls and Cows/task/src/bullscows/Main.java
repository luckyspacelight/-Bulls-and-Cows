package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // This is the Secret Number
    //private final  static String SECRET_NUMBER = Helper.generateSecretNumber();
    //private final  static String SECRET_NUMBER = "9305";

    public static void main(String[] args) {

        /*
        String tryNum = Helper.guessTheNumber();

        Grader grader = new Grader(tryNum, SECRET_NUMBER);
        String grade = grader.determineTheGrade();
        System.out.println(grade);
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println(Helper.generateSecretNumber(scanner.nextInt()));


    }

}
