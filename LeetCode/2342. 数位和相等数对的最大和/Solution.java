class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        int x = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            x = mumSum(num);
            if(map.containsKey(x)){
                ans = Math.max(ans,num+map.get(x));
            }
            map.put(x,Math.max(num,map.getOrDefault(x,0)));
        }
        return ans;
    }
    public int mumSum(int num) {
        if(num < 10){
            return num;
        }
        return num % 10 +mumSum(num/10);
    }
}