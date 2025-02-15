import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxSafeArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        buildWall(0);
        
        System.out.println(maxSafeArea);
    }
    
    static void buildWall(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;  
                    buildWall(count + 1);
                    map[i][j] = 0;  
                }
            }
        }
    }
    
    static void spreadVirus() {
        int[][] copyMap = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2) {
                    dfs(i, j, copyMap);
                }
            }
        }
        
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
    
    static void dfs(int x, int y, int[][] copyMap) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    dfs(nx, ny, copyMap);
                }
            }
        }
    }
}