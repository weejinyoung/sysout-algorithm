import java.io.*;

class Main {
   
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());
       
       StringBuilder sb = new StringBuilder();
       for(int t = 0; t < T; t++) {
           int L = Integer.parseInt(br.readLine());
           sb.append(solution(L)).append('\n');
       }
       
       System.out.print(sb);
       br.close();
   }
   
   public static int solution(int L) {
       if (L % 2 == 1) {
           return 0;
       }
       
       long[][] dp = new long[L + 1][L/2 + 1];
       dp[0][0] = 1;
       
       for (int i = 0; i < L; i++) {
           for (int j = 0; j <= L/2; j++) {
               if (dp[i][j] == 0) continue;
               
               if (j < L/2) {
                   dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % 1000000007;
               }
               
               if (j > (i-j)) {
                   dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % 1000000007;
               }
           }
       }
       
       return (int)dp[L][L/2];
   }
}