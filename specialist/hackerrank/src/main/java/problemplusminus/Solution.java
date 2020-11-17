package problemplusminus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {

//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("Positive", 0);
//        map.put("Negative", 0);
//        map.put("Zero", 0);

        double positive = 0;
        double negative = 0;
        double zero = 0;

        for (int i : arr) {
            if (i > 0) {
                positive++;
//                map.put("Positive", map.get("Positive") + 1);
            } else if (i < 0) {
                negative++;
//                map.put("Negative", map.get("Negative") + 1);
            } else {
                zero++;
//                map.put("Zero", map.get("Zero") + 1);
            }
        }

        System.out.printf(Locale.ENGLISH, "%.6f\n",  positive / arr.length);
        System.out.printf(Locale.ENGLISH, "%.6f\n",  negative / arr.length);
        System.out.printf(Locale.ENGLISH, "%.6f\n",  zero / arr.length);
//        System.out.printf(Locale.ENGLISH, "%.6f\n", (double) map.get("Positive") / arr.length);
//        System.out.printf(Locale.ENGLISH, "%.6f\n", (double) map.get("Negative") / arr.length);
//        System.out.printf(Locale.ENGLISH, "%.6f\n", (double) map.get("Zero") / arr.length);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
