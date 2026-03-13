class Solution {
    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;
        while(left <= right){
            if(maxLeft < maxRight){//要加左边
                if(maxLeft > height[left]){
                    res += maxLeft - height[left];
                }else{
                    maxLeft = height[left];
                }
                left++;
            }else{
                if(maxRight > height[right]){
                    res += maxRight - height[right];
                }else{
                    maxRight = height[right];
                }
                right--;
            }
        }
        return res;
    }
}