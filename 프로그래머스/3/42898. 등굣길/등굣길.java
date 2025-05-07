import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        
        // DP 배열 초기화
        int[][] dp = new int[m+1][n+1];
        
        // 물웅덩이 위치 표시
        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1; // 물웅덩이는 -1로 표시
        }
        
        // 시작점 설정
        dp[1][1] = 1;
        
        // DP 계산
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 시작점이거나 물웅덩이면 건너뛰기
                if ((i == 1 && j == 1) || dp[i][j] == -1) {
                    continue;
                }
                
                // 위쪽에서 오는 경로
                int fromUp = (dp[i-1][j] == -1) ? 0 : dp[i-1][j];
                
                // 왼쪽에서 오는 경로
                int fromLeft = (dp[i][j-1] == -1) ? 0 : dp[i][j-1];
                
                // 두 방향의 경로 수 합산 (모듈로 연산)
                dp[i][j] = (fromUp + fromLeft) % MOD;
            }
        }
        
        return dp[m][n];
    }
}