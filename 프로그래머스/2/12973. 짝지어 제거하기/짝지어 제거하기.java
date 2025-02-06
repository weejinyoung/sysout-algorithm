import java.util.*;

class Solution {
    
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        String[] elmts = s.split("");
        for(int i = 0; i < elmts.length; i++) {
           if(!stack.isEmpty()) {
               if(stack.peek().equals(elmts[i])) {
                  stack.pop(); 
               } else {
                  stack.push(elmts[i]);
               }
           }
            else {
               stack.push(elmts[i]);
            }
        }
        if(stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}