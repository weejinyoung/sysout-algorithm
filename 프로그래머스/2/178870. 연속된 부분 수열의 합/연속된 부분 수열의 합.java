class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = 0;
        int start = 0, end = 0;
        int len = -1;
        for (;  start < sequence.length; start++) {
			while(end < sequence.length && sum < k) {
				sum += sequence[end++];
			}
			
			if (sum == k) {
				if (len == -1 || len > end - start) {
					answer[0] = start;
					answer[1] = end-1;
					len = end - start;
				}
			}
			
			sum -= sequence[start];
		}
        
        return answer;
    }
}