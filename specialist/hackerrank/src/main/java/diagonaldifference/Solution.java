package diagonaldifference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        int i = 0;

        // finding sum of primary diagonal
        for (i = 0; i < arr.size(); i++) {
            firstDiagonal += arr.get(i).get(i);
        }

        // finding sum of secondary diagonal
        for (i = 0; i < arr.size(); i++) {
            secondDiagonal += arr.get(i).get(arr.size() - (i + 1));
        }

        // Absolute difference of the sums
        // across the diagonals
        return Math.abs(firstDiagonal - secondDiagonal);

        // alternative
       /*
        int diagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            diagonal += arr.get(i).get(i);
            diagonal - +arr.get(i).get(arr.size() - (i + 1));
        }

        return Math.abs(diagonal);
        */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        System.out.println(arr);

        int result = Result.diagonalDifference(arr);

        System.out.println(result);

        bufferedReader.close();
    }
}
