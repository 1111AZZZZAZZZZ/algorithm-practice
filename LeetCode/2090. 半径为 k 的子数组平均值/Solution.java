import java.util.*;
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = 0;i < n;i++){
            sum += nums[i];
            if(i < 2*k){
                continue;
            }
            // int left = i - k*2;
            // if(left < 0){
            //     ans[i-k] = - (k+k+1);
            //     continue;
            // }
            ans[i-k] = (int) (sum / (k * 2 + 1));;
            sum -= nums[i - k*2];
        }
        return ans;
    }
}