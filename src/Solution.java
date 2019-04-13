import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        if (sumsAreEqual(arr)) {
            return "YES";
        }
        return "NO";
    }

    static boolean sumsAreEqual(List<Integer> arr) {
        ArrayList<Integer> arrayList = new ArrayList<>(arr);
        int sumB = 0;
        int sumA = arr.stream().mapToInt(Integer::intValue).sum() - arr.get(0);
        if (sumA == sumB)
            return true;

        for (int numInList = 1; numInList < arrayList.size(); numInList++) {
            sumB += arrayList.get(numInList - 1);
            sumA -= arrayList.get(numInList);

            if (sumA == sumB) {
                return true;
            }


        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
