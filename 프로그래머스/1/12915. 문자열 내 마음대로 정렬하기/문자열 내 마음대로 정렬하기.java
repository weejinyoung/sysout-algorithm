import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            String s1IndexString = String.valueOf(s1.charAt(n));
            String s2IndexString = String.valueOf(s2.charAt(n));
            if(s1IndexString.equals(s2IndexString)) {
                return s1.compareTo(s2);
            }
            return s1IndexString.compareTo(s2IndexString);
        });
        return strings;
    }
}