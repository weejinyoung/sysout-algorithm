import java.util.*;
import java.io.*;

class Solution {
    
    String[] alphabats = {"A", "E", "I", "O", "U"};
    TreeSet<String> dictionary = new TreeSet<>();
    int result = 0;
    
    public int solution(String word) {
        dfs(0, "");
        int count = 1;
        for(String elmnt : dictionary) {
            if(word.equals(elmnt)) {
                return count;
            }
            count++;
        }
        return 0;
    }
    
    public void dfs(int depth, String current) {
        if(depth > 4) {
            if(!current.equals("")) {
                dictionary.add(current);
            }
            return;
        }
        for(int i = 0; i < alphabats.length; i++) {
            dfs(depth + 1, current + alphabats[i]);
            dfs(depth + 1, current);
        }
    }
}