import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (lastSeenIndex.containsKey(currentChar)) {
                answer[i] = i - lastSeenIndex.get(currentChar);
            } else {
                answer[i] = -1;
            }
            
            lastSeenIndex.put(currentChar, i);
        }
        
        return answer;
    }
}