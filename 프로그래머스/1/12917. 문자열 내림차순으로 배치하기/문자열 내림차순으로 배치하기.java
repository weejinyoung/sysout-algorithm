import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArray = s.split("");
        Arrays.sort(sArray, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String sElmnt : sArray) {
            sb.append(sElmnt);
        }
        return sb.toString();
    }
}