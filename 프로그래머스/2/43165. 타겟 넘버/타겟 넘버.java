import java.util.*;

class Solution {
    int result = 0;
    
    public int solution(int[] numbers, int target) {
        backtrack(0, 0, target, numbers);
        return result;
    }
    
    public void backtrack(int depth, int current, int target, int[] numbers) {
        if(depth >= numbers.length) {
            if(current == target) {
                result++;
            }
            return;
        }
        backtrack(depth + 1, current + numbers[depth], target, numbers);
        backtrack(depth + 1, current - numbers[depth], target, numbers);
    }
}