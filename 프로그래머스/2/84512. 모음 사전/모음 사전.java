import java.util.*;
import java.io.*;

class Solution {
    
    String[] alphabats = {"A", "E", "I", "O", "U"};
    List<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        dfs(0, "");
        return dictionary.indexOf(word) + 1;
    }
    
    public void dfs(int depth, String current) {
        if(depth > 0) {
            dictionary.add(current);
        }
        if(depth == 5) {
            return;
        }
        for(int i = 0; i < alphabats.length; i++) {
            dfs(depth + 1, current + alphabats[i]);
        }
    }
}