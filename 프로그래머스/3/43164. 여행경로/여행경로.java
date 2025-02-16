import java.util.*;

class Solution {
    private boolean[] used;
    private ArrayList<String> route;
    private String[] answer;
    
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        route = new ArrayList<>();
        
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        route.add("ICN");
        dfs("ICN", tickets, 0);
        
        return answer;
    }
    
    private boolean dfs(String current, String[][] tickets, int count) {
        // 모든 티켓을 사용했다면
        if(count == tickets.length) {
            answer = route.toArray(new String[0]);
            return true;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                route.add(tickets[i][1]);
                
                if(dfs(tickets[i][1], tickets, count + 1)) {
                    return true;
                }
                
                used[i] = false;
                route.remove(route.size() - 1);
            }
        }
        
        return false;
    }
}