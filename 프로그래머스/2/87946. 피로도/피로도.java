import java.io.*;

class Solution {
    
    int result = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return result;
    }
    
    public void dfs(int count, int k, int[][] dungeons) {
        result = Math.max(result, count);
        if(k <= 0 || count >= dungeons.length) {
            return;
        }
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            dfs(count + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
}