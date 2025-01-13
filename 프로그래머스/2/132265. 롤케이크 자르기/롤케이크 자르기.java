import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> big = new HashMap<>(); 
        Map<Integer, Integer> little = new HashMap<>();
        
        for (int e : topping) {
            little.put(e, little.getOrDefault(e, 0) + 1);
        }
        
        for (int e : topping) {
            big.put(e, big.getOrDefault(e, 0) + 1);
            
            if (little.get(e) - 1 == 0)
                little.remove(e);
            else
                little.put(e, little.get(e) - 1);  
            
            if (big.size() == little.size())
                answer++;
        }

        return answer;
    }
}