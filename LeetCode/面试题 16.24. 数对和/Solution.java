import java.util.*;
class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff) > 0){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(diff);
                map.replace(diff,map.get(diff)-1);
                ans.add(list);
            }else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        
        return ans;
    }
}