import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        if(nextPermutation(nums)) {
            for(int i = 0; i < N; i++) {
                System.out.print(nums[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
    
    private static boolean nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i > 0 && nums[i-1] >= nums[i]) i--;
        if(i <= 0) return false;
        
        int j = nums.length - 1;
        while(nums[j] <= nums[i-1]) j--;
        
        swap(nums, i-1, j);
        
        int k = nums.length - 1;
        while(i < k) {
            swap(nums, i, k);
            i++;
            k--;
        }
        
        return true;
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}