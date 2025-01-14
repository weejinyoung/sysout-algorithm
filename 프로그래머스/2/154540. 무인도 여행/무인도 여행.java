import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static char[][] island;
    public static boolean[][] visited;
    public static int N, M;

    public static int dfs(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M){
            return 0;
        }
        if(visited[x][y] || island[x][y] == 'X'){
            return 0;
        }
        
        visited[x][y] = true;
        int current = island[x][y] - '0';
        
        return current + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x + 1, y) + dfs(x, y - 1);
    }
    public static int[] solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();

        island = new char[N][M];
        visited = new boolean[N][M];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            String current = maps[i];
            island[i] = current.toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (island[i][j] == 'X') {
                    continue;
                }
                int sum = dfs(i, j);
                if(sum > 0){
                    list.add(sum);
                }
            }
        }

        if(list.size() == 0){
            return new int[]{-1};
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}