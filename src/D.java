import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*Problem D: Let's Predict the Next Word*/

public class D {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()), CASE = 1;

        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine());

            ArrayList<String[]> corpusData = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                corpusData.add((br.readLine() + " #").split(" "));
            }

            int M = Integer.parseInt(br.readLine());

            System.out.println("Case " + (CASE++) + ":");

            for (int i = 0; i < M; i++) {

                HashMap<String, Integer> wordCount = new HashMap<>();
                String input = br.readLine();
                String tofind = input.split(" ")[input.split(" ").length - 1];

                for (String[] strings : corpusData) {

                    for (int j = 0; j < strings.length; j++) {

                        if (strings[j].equals(tofind)) {
                            String toadd = strings[j + 1];

                            if (!wordCount.containsKey(toadd)) {
                                wordCount.put(toadd, 1);
                            } else {
                                wordCount.put(toadd, wordCount.get(toadd) + 1);
                            }
                        }
                    }
                }

                Set<String> keys = wordCount.keySet();

                int max = 0;

                for (String k : keys) {
                    if (wordCount.get(k) > max) {
                        max = wordCount.get(k);
                    }
                }

                for (String k : keys) {
                    if (max == wordCount.get(k)) {
                        System.out.println(k.toLowerCase());
                    }
                }


            }
        }
    }
}
