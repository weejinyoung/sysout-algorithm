import java.util.*;

class Solution {
        
    static class Coordinate {
        public int x;
        public int y;
        public int depth;
        
        public Coordinate(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    
    public int solution(int[][] maps) {
        return bfs(0, 0, maps);
    }

    public List<Coordinate> getNeighbors(Coordinate current, int[][] maps) {
        List<Coordinate> neighbors = new ArrayList<>();
        if(current.x < maps.length - 1) {
            neighbors.add(new Coordinate(current.x + 1, current.y, current.depth + 1));
        }
        if(current.y < maps[0].length - 1) {
            neighbors.add(new Coordinate(current.x, current.y + 1, current.depth + 1));
        }
        if(current.x > 0) {
            neighbors.add(new Coordinate(current.x - 1, current.y, current.depth + 1));
        }
        if(current.y > 0) {
            neighbors.add(new Coordinate(current.x, current.y - 1, current.depth + 1));
        }
        return neighbors;
    }
    
    public int bfs(int x, int y, int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(x, y, 1));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Coordinate current = q.poll();
            for(Coordinate neighbor : getNeighbors(current, maps)) {
                if(!visited[neighbor.x][neighbor.y] && maps[neighbor.x][neighbor.y] == 1) {
                    if(neighbor.x == maps.length - 1 && neighbor.y == maps[0].length - 1) {
                        return neighbor.depth;
                    }
                    visited[neighbor.x][neighbor.y] = true;
                    q.add(neighbor);
                }
            }
        }
        return -1;
    }
}