class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        int n = arr.length;
        int even = 1,odd = 0;
        int s = 0;
        int subarray = 0;
        for(int i = 0;i < n;i++){
            s += arr[i];
            subarray = (subarray+(s%2==0?odd:even))%MOD;
            if(s%2==0){
                even++;
            }else{
                odd++;
            }
        }
        return subarray;
    }
}