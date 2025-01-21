import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1) / 2];
        int[][] matrix = new int[n][n];
        
        int x = -1, y = 0, value = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) {
                    x++;
                }
				else if(i % 3 == 1) {
                    y++;
                }
				else if(i % 3 == 2) {
                    x--;
                    y--;
                }
                matrix[x][y] = value++;
            }
        }
        
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    break;
                }
                answer[index++] = matrix[i][j];
            }
        }
        
        return answer;
    }
}
