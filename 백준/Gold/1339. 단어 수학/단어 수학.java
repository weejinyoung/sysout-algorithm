import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        Map<Character, Long> weightMap = new HashMap<>();  

        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                long weight = (long)Math.pow(10, word.length() - j - 1);
                weightMap.put(c, weightMap.getOrDefault(c, 0L) + weight);
            }
        }

        List<Character> sortedAlpha = new ArrayList<>(weightMap.keySet());
        sortedAlpha.sort((a, b) -> weightMap.get(b).compareTo(weightMap.get(a)));

        Map<Character, Integer> numberMap = new HashMap<>();
        int number = 9;
        for(char c : sortedAlpha) {
            numberMap.put(c, number--);
        }

        long sum = 0;
        for(String word : words) {
            long num = 0;
            for(char c : word.toCharArray()) {
                num = num * 10 + numberMap.get(c);
            }
            sum += num;
        }

        System.out.println(sum);
        br.close();
    }
}