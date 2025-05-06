import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<String> stack = new Stack<>();
        String[] numberArr = number.split("");
        
        for (String numberElmnt : numberArr) {
            int current = Integer.parseInt(numberElmnt);
    
            while (!stack.isEmpty() && Integer.parseInt(stack.peek()) < current && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(numberElmnt);
        }
        while(k > 0) {
            stack.pop();
            k--;
        }
        return stack.toString().replaceAll("[^0-9]", "");
    }
}