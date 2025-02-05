import java.util.*;

class Solution{
    
    public int solution(int []A, int []B){
        ArrayDeque<Integer> Aq = new ArrayDeque<>();
        ArrayDeque<Integer> Bq = new ArrayDeque<>();
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++) {
            Aq.add(A[i]);
            Bq.add(B[i]);
        }
        int answer = 0;
        for(int i = 0; i < A.length; i++) {
            int first = Aq.peekFirst() * Bq.peekLast();
            int second = Bq.peekFirst() * Aq.peekLast();
            if(first >= second) {
                answer += Aq.pollFirst() * Bq.pollLast();
            } else {
                answer += Bq.pollFirst() * Aq.pollLast();
            }
        }
    
        System.out.println(answer);

        return answer;
    }
}