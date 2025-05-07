import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clotheMap = new HashMap<>();
        for(String[] clothe : clothes) {
            if(clotheMap.containsKey(clothe[1])) {
                int nextCount = clotheMap.get(clothe[1]) + 1;
                clotheMap.put(clothe[1], nextCount);
                continue;
            }
            clotheMap.put(clothe[1], 1);
        }
        int answer = 1;
        for(String key : clotheMap.keySet()) {
            int count = clotheMap.get(key) + 1;
            answer *= count;
        }
        return answer - 1;
    }
}