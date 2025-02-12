class Solution {
    public String solution(int n) {
        StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            n -= 1;
            int remainder = n % 3;
            if (remainder == 0) {
                result.insert(0, "1");
            } else if (remainder == 1) {
                result.insert(0, "2");
            }
            else {
                result.insert(0, "4");
            }
            n /= 3;
        }
        
        return result.toString();
    }
}