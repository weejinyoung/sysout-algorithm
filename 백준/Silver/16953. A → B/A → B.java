import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int result = getResult(A, B);
        System.out.println(result);
    }
    
    static int getResult(int A, int B) {
        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(new Pair(B, 0));
        visited.add(B);
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int num = current.num;
            int count = current.count;
            
            if (num == A) {
                return count + 1;
            }
            
            if (num % 2 == 0) {
                int next = num / 2;
                if (next >= A && !visited.contains(next)) {
                    queue.offer(new Pair(next, count + 1));
                    visited.add(next);
                }
            }
            
            if (num % 10 == 1) {
                int next = num / 10;
                if (next >= A && !visited.contains(next)) {
                    queue.offer(new Pair(next, count + 1));
                    visited.add(next);
                }
            }
        }
        
        return -1;
    }
    
    static class Pair {
        int num, count;
        
        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}