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
    
    int minX = Integer.MAX_VALUE;
    int maxX = 0;
    int minY = Integer.MAX_VALUE;
    int maxY = 0;
    
    public boolean isPossibleOutline(Coordinate coordinate, int[][] rectangles) {
        // 1. 어느 한 직사각형의 윤곽선에 있는지 확인
        boolean onAnyOutline = false;
        for(int[] rectangle : rectangles) {
            if(isSingleSquareOutline(coordinate, rectangle)) {
                onAnyOutline = true;
                break;
            }
        }
        
        if(!onAnyOutline) return false;
        
        // 2. 어느 직사각형의 내부에도 있지 않은지 확인
        return !isInRectangle(coordinate, rectangles);
    }
    
    public boolean isInRectangle(Coordinate coordinate, int[][] rectangles) {
        int x = coordinate.x;
        int y = coordinate.y;
        for(int[] rectangle : rectangles) {
            if(x < rectangle[2] && x > rectangle[0] && y < rectangle[3] && y > rectangle[1]) return true;
        }
        return false;    
    }
    
    public boolean isSingleSquareOutline(Coordinate coordinate, int[] rectangle) {
        int x = coordinate.x;
        int y = coordinate.y;
        // 왼쪽 윤곽선: x는 왼쪽 경계이고 y는 위아래 경계 사이
        boolean isLeftOutline = (x == rectangle[0] && y >= rectangle[1] && y <= rectangle[3]);
        // 오른쪽 윤곽선: x는 오른쪽 경계이고 y는 위아래 경계 사이
        boolean isRightOutline = (x == rectangle[2] && y >= rectangle[1] && y <= rectangle[3]);
        // 아래쪽 윤곽선: y는 아래쪽 경계이고 x는 좌우 경계 사이
        boolean isBottomOutline = (y == rectangle[1] && x >= rectangle[0] && x <= rectangle[2]);
        // 위쪽 윤곽선: y는 위쪽 경계이고 x는 좌우 경계 사이
        boolean isTopOutline = (y == rectangle[3] && x >= rectangle[0] && x <= rectangle[2]);
        // 전체 윤곽선 확인
        return isLeftOutline || isRightOutline || isBottomOutline || isTopOutline;    
    }
    
    public List<Coordinate> getNeighbors(Coordinate current) {
        List<Coordinate> neighbors = new ArrayList<>();
        int x = current.x;
        int y = current.y;
        int depth = current.depth;
        
        // 4방향 이동 (상, 우, 하, 좌)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 경계 체크
            if(nx >= minX && nx <= maxX && ny >= minY && ny <= maxY) {
                neighbors.add(new Coordinate(nx, ny, depth + 1));
            }
        }
        
        return neighbors;
    }
    
    public int bfs(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[101][101]; // 2배 스케일링으로 인해 최대 100까지
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(characterX, characterY, 0));
        visited[characterX][characterY] = true;
        
        while(!q.isEmpty()) {
            Coordinate current = q.poll();
            
            // 현재 위치가 아이템 위치인지 확인
            if(current.x == itemX && current.y == itemY) {
                return current.depth;
            }
            
            for(Coordinate neighbor : getNeighbors(current)) {
                if(!visited[neighbor.x][neighbor.y] && isPossibleOutline(neighbor, rectangles)) {
                    visited[neighbor.x][neighbor.y] = true;
                    q.add(neighbor);
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 모든 좌표 2배 스케일링
        int[][] scaled = new int[rectangle.length][4];
        for(int i = 0; i < rectangle.length; i++) {
            scaled[i][0] = rectangle[i][0] * 2;
            scaled[i][1] = rectangle[i][1] * 2;
            scaled[i][2] = rectangle[i][2] * 2;
            scaled[i][3] = rectangle[i][3] * 2;
        }
        
        int scaledCharX = characterX * 2;
        int scaledCharY = characterY * 2;
        int scaledItemX = itemX * 2;
        int scaledItemY = itemY * 2;
        
        // 경계값 계산 초기화 (스케일링된 값으로)
        minX = Integer.MAX_VALUE;
        maxX = 0;
        minY = Integer.MAX_VALUE;
        maxY = 0;
        
        for(int[] rect : scaled) {
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);
        }
        
        // BFS 실행 (스케일링된 좌표로)
        int result = bfs(scaled, scaledCharX, scaledCharY, scaledItemX, scaledItemY);
        
        // 결과값을 2로 나눔 (스케일링 효과 제거)
        return result / 2;
    }
}