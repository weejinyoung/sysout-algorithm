import java.util.*;
class Solution {
    
    boolean[] visited;
    int networkCount = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, computers);
                networkCount++;
            }
        }
        return networkCount;
    }
    
    public void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int current = q.poll();
            for(int i = 0; i < computers[current].length; i++) {
                if(computers[current][i] == 1 && !visited[i] && current != i) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}