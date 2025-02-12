import java.io.*;

class Main {
    static final int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int L = Integer.parseInt(br.readLine());
            sb.append(solution(L)).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
    
    public static int solution(int L) {
        if (L % 2 == 1) return 0;
        
        int n = L/2;
        // C(n) = (2n)! / ((n+1)!n!)
        return catalanNumber(n);
    }
    
    private static int catalanNumber(int n) {
        // 분자: (2n)!
        // 분모: (n+1)! * n!
        // 모듈러 연산의 나눗셈은 페르마의 소정리 사용
        
        long numerator = factorial(2*n);  // 분자
        long denominator = (factorial(n+1) * factorial(n)) % MOD;  // 분모
        
        // 페르마의 소정리를 이용한 모듈러 곱셈의 역원
        // a^(p-1) ≡ 1 (mod p) 일 때, a^(p-2)가 a의 모듈러 곱셈의 역원
        long inverse = power(denominator, MOD-2);
        
        return (int)((numerator * inverse) % MOD);
    }
    
    private static long factorial(int n) {
        long result = 1;
        for(int i = 2; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
    
    private static long power(long base, int exponent) {
        if(exponent == 0) return 1;
        if(exponent == 1) return base;
        
        long half = power(base, exponent/2) % MOD;
        if(exponent % 2 == 0) {
            return (half * half) % MOD;
        } else {
            return (((half * half) % MOD) * base) % MOD;
        }
    }
}