import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int max = 0;
        int head = 0;
        int count = 0;
        for(int num: set){//注意这里是要set，不能用nums遍历：set去重（提高效率）
            count = 0;
            if(!set.contains(num - 1)){//头
                head = num;
                count ++;
                while(set.contains(head+1)){
                    count++;
                    head++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
}