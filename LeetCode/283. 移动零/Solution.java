// package LeetCode.283. 移动零;

class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int num = nums.length;
        for(int i = 0;i < num;i++){
            if(nums[i]==0){
                continue;
            }
            if(index < i){
                nums[index] = nums[i];
            }
            index ++;
        }
        for(int i = index;i < num;i++){
            nums[i] = 0;
        }

        
    }
}
