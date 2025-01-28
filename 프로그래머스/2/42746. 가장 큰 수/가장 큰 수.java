import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        for (String s : strNumbers) {
            answer += s;
        }

        return answer;
    }
}
