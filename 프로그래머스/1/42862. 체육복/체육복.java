import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        int lostCount = lost.length;
        Arrays.fill(students, 1);
        for(int lostElement: lost) {
            students[lostElement - 1]--;
        }
        for(int reserveElement: reserve) {
            students[reserveElement - 1]++;
        }
        for(int i = 0; i < n; i++) {
            if(students[i] == 0) {
                if(i > 0 && students[i - 1] == 2) {
                    students[i]++;
                    students[i - 1]--;
                    lostCount--;
                } else if(i < n - 1 && students[i + 1] == 2) {
                    students[i]++;
                    students[i + 1]--;
                    lostCount--;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(students[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}