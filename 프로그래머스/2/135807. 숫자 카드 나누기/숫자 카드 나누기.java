import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int tempA = arrayA[0];
        for (int i = 1 ; i < arrayA.length ; i++){
            tempA = gcd(arrayA[i], tempA);
            
            if (tempA == 1)
                break;
        }
        
        int tempB = arrayB[0];
        for (int i = 1 ; i < arrayB.length ; i++){
            tempB = gcd(arrayB[i], tempB);
            
            if (tempB == 1)
                break;
        }
        

        if (div(arrayA, tempB)){
            answer = Math.max(answer, tempB);
        }
        
        if (div(arrayB, tempA)){
            answer = Math.max(answer, tempA);
        }
        
        return answer; 
    }
    public int gcd (int a, int b){
        if (a%b == 0) return b;

        else return gcd (b, a%b);
      
    }
    public boolean div (int[] arr, int num){
        for (int a : arr){
            if (a%num == 0)
                return false;
        }
        return true;
    }
}