import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};  
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        int[] start = new int[2];
        int[] end = new int[2];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                if(board[i].charAt(j) == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        // BFS 탐색을 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        // 방문 체크를 위한 배열
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new int[]{start[0], start[1], 0});  
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];
            
            if(x == end[0] && y == end[1]) {
                return moves;
            }
            
            for(int i = 0; i < 4; i++) {
                int[] next = slide(x, y, i, board);
                int nx = next[0];
                int ny = next[1];
                
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, moves + 1});
            }
        }
        
        return -1;  
    }
    
    private int[] slide(int x, int y, int direction, String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        while(true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || 
               board[nx].charAt(ny) == 'D') {
                return new int[]{x, y};
            }
            
            x = nx;
            y = ny;
        }
    }
}