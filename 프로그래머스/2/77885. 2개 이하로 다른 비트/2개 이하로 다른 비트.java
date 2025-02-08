class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = findNext(numbers[i]);
        }
        
        return answer;
    }
    
    private long findNext(long n) {
        String binary = Long.toBinaryString(n);
        
        if (!binary.contains("0")) {
            return n + (long)Math.pow(2, binary.length() - 1);
        }
        
        int lastZeroPos = binary.lastIndexOf('0');
        int firstOneAfterZero = binary.indexOf('1', lastZeroPos);
        
        if (firstOneAfterZero == -1) {
            return n + 1;
        } else {
            long flipMask = (1L << (binary.length() - lastZeroPos - 1));
            if (firstOneAfterZero == lastZeroPos + 1) {
                flipMask |= (1L << (binary.length() - firstOneAfterZero - 1));
            }
            return n ^ flipMask;
        }
    }
}