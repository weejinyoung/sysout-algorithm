import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new Word(begin, 0));
        
        while(!queue.isEmpty()) {
            Word current = queue.poll();
            
            if(current.word.equals(target)) {
                return current.count;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && canConvert(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], current.count + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean canConvert(String current, String next) {
        int diff = 0;
        for(int i = 0; i < current.length(); i++) {
            if(current.charAt(i) != next.charAt(i)) {
                diff++;
            }
            if(diff > 1) return false;
        }
        return diff == 1;
    }
    
    class Word {
        String word;
        int count;
        
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}