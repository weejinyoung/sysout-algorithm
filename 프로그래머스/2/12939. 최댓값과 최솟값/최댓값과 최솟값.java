import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sSplit = s.split(" ");
        int[] iSplit = new int[sSplit.length];
        for(int i = 0; i < sSplit.length; i++) {
            iSplit[i] = Integer.parseInt(sSplit[i]);
        }
        Arrays.sort(iSplit);
        StringBuilder sb = new StringBuilder();
        return sb.append(iSplit[0]).append(" ").append(iSplit[iSplit.length - 1]).toString();
    }
}