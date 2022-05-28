import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PersonalityTest {
    public static void main(String[] args) throws FileNotFoundException{

        Scanner input = new Scanner(new File("personality.txt"));
        PrintStream output = new PrintStream(new File("output.text"));

        while (input.hasNext()){
            output.println(input.nextLine() + ": " + returnScore(calculateScores(input.nextLine())));
        }

    }
    public static int[] calculateScores(String rawResults){

        String results = rawResults.toUpperCase();

        int[] aResults = new int[4];
        int[] bResults = new int[4];
        int[] finalResults = new int[4];

        int count = 0;

        for (int i = 0; i < results.length(); i++){
            if (count == 0) {
                System.out.println("ct 0 " + results.charAt(i) + " " + i);
                if (results.charAt(i) == 'A')
                    aResults[0]++;
                else if (results.charAt(i) == 'B') {
                    bResults[0]++;
                }
                count++;
            } else if (count  == 1 || count == 2) {
                if (results.charAt(i) == 'A')
                    aResults[1]++;
                else if (results.charAt(i) == 'B') {
                    bResults[1]++;
                }
                count++;
            } else if (count == 3 || count == 4) {
                if (results.charAt(i) == 'A')
                    aResults[2]++;
                else if (results.charAt(i) == 'B') {
                    bResults[2]++;
                }
                count++;
            } else if (count == 5 || count == 6) {
                if (results.charAt(i) == 'A')
                    aResults[3]++;
                else if (results.charAt(i) == 'B') {
                    bResults[3]++;
                }
                count++;
                if (count == 7)
                    count = 0;
            }
        }

        // Calculate results, multiply by 10 to deal with int rounding
        for (int i = 0; i < finalResults.length; i++){
            finalResults[i] = bResults[i] * 10 / (aResults[i] + bResults[i]) * 10;
        }
        return finalResults;
    }

    public static String returnScore(int[] scores){
        String result = "";

        // Extrovert/Introvert
        if (scores[0] < 50)
            result += "E";
        else if (scores[0] > 50)
            result += "I";
        else
            result += "X";

        // Sensing/Intuition
        if (scores[1] < 50)
            result += "S";
        else if (scores[1] > 50)
            result += "N";
        else
            result += "X";

        // Thinking/Feeling
        if (scores[2] < 50)
            result += "T";
        else if (scores[2] > 50)
            result += "F";
        else
            result += "X";

        // Judging/Perceiving
        if (scores[3] < 50)
            result += "J";
        else if (scores[3] > 50)
            result += "P";
        else
            result += "X";

        return Arrays.toString(scores) + " = " + result;
    }
}
