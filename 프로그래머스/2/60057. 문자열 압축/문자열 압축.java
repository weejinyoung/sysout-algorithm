import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length(); // 압축하지 않았을 때의 길이로 초기화
        
        // 1개 단위부터 문자열 길이의 절반까지 압축 단위 시도
        for (int len = 1; len <= s.length() / 2; len++) {
            // 압축된 문자열 길이
            int compressedLength = compress(s, len);
            // 최소 길이 갱신
            answer = Math.min(answer, compressedLength);
        }
        
        return answer;
    }
    
    private int compress(String s, int unit) {
        StringBuilder result = new StringBuilder();
        String prev = ""; // 이전 부분 문자열
        int count = 1;    // 반복 횟수
        
        for (int i = 0; i < s.length(); i += unit) {
            // 현재 단위만큼의 부분 문자열 추출 (범위 초과 방지)
            String curr;
            if (i + unit <= s.length()) {
                curr = s.substring(i, i + unit);
            } else {
                curr = s.substring(i); // 남은 부분 전체
            }
            
            // 이전 부분 문자열이 있고, 현재 부분 문자열과 같으면
            if (prev.equals(curr)) {
                count++;
            } else {
                // 이전 부분 문자열이 있으면 결과에 추가
                if (!prev.isEmpty()) {
                    // 반복 횟수가 1보다 크면 숫자 추가
                    if (count > 1) {
                        result.append(count);
                    }
                    result.append(prev);
                }
                // 새로운 부분 문자열로 초기화
                prev = curr;
                count = 1;
            }
        }
        
        // 마지막 부분 문자열 처리
        if (count > 1) {
            result.append(count);
        }
        result.append(prev);
        
        return result.length();
    }
}