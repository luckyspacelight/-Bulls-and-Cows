import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] maxRandNPerSeed = new int[1][2]; // The maximum of these N numbers
        int[][] minMaxRPS = new int[1][2]; // The minimum among all maximums of other seeds

        for (int seed = a; seed <= b; seed++) {
            Random random = new Random(seed);
            for (int i = 0; i < n; i++) {
                int randNum = random.nextInt(k);

                if (randNum > maxRandNPerSeed[0][1]) {
                    maxRandNPerSeed[0][0] = seed;
                    maxRandNPerSeed[0][1] = randNum;
                }
            }

            if (seed == a || maxRandNPerSeed[0][1] < minMaxRPS[0][1]) {
                minMaxRPS[0][1] = maxRandNPerSeed[0][1];
                minMaxRPS[0][0] = maxRandNPerSeed[0][0];
            } else if (maxRandNPerSeed[0][1] == minMaxRPS[0][1]
                    && maxRandNPerSeed[0][0] < minMaxRPS[0][0]) {
                minMaxRPS[0][1] = maxRandNPerSeed[0][1];
                minMaxRPS[0][0] = maxRandNPerSeed[0][0];
            }

            // Reset the max of these N numbers
            maxRandNPerSeed[0][1] = 0;
            maxRandNPerSeed[0][0] = 0;
        }

        // Print result
        System.out.println(minMaxRPS[0][0]);
        System.out.println(minMaxRPS[0][1]);
    }
}