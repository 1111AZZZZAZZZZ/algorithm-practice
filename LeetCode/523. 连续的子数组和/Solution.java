class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        boolean ans = false;
        if(nums.length < 2){
            return false;
        }
        int s = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0;i < nums.length;i++){
            s = (s+nums[i])%k;
            if(map.containsKey(s)){
                if(i - map.get(s)>=2)
                return true;
            }else{
                map.put(s,i);
            }
        }
        return ans;
    }
}