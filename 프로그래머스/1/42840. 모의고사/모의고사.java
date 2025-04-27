import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        Arrays.fill(score, 0);
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        for(int i = 0; i < answers.length; i++) {
            if(first[i % 5] == answers[i]) {
                score[0]++;
            }
            if(second[i % 8] == answers[i]) {
                score[1]++;
            }
            if(third[i % 10] == answers[i]) {
                score[2]++;
            }
        }
        
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < score.length; i++) {
            if(treeMap.containsKey(score[i])) {
                treeMap.get(score[i]).add(i + 1);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i + 1);
                treeMap.put(score[i], newList);
            }
        }
        return treeMap.firstEntry().getValue().stream().mapToInt(i -> i).toArray();
    }
}