import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String[] xArray = X.split("");
        String[] yArray = Y.split("");
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();
        for(int i = 0; i < xArray.length; i++) {
            if(xMap.containsKey(xArray[i])) {
                int value = xMap.get(xArray[i]);
                value++;
                xMap.put(xArray[i], value);
            } else {
                xMap.put(xArray[i], 1);
            }
        }
        for(int i = 0; i < yArray.length; i++) {
            if(yMap.containsKey(yArray[i])) {
                int value = yMap.get(yArray[i]);
                value++;
                yMap.put(yArray[i], value);
            } else {
                yMap.put(yArray[i], 1);
            }
        }
        int xLength = xArray.length;
        int yLength = yArray.length;
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        if(xLength <= yLength) {
            for(String key : xMap.keySet()) {
                if(yMap.containsKey(key)) {
                    for(int i = 0; i < Math.min(yMap.get(key), xMap.get(key)); i++) {
                        pq.offer(key);
                    }
                }
            }
        } else {
            for(String key : yMap.keySet()) {
                if(xMap.containsKey(key)) {
                    for(int i = 0; i < Math.min(yMap.get(key), xMap.get(key)); i++) {
                        pq.offer(key);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        String answer = sb.toString();
        if(answer.equals("")) {
            answer = "-1";
        } 
        if(answer.charAt(0) == '0') {
            answer = "0";
        }
        return answer;
    }
}