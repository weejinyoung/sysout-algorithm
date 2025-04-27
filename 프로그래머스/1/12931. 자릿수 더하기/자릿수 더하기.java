import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] nArray = String.valueOf(n).split("");
        for(String nElement: nArray) {
            answer += Integer.parseInt(nElement);
        }
        return answer;
    }
}