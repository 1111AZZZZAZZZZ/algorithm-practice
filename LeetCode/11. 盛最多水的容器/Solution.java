// class Solution {
//     public int maxArea(int[] height) {
//         int count = height.length;
//         int maxVolume = 0;
//         for(int j = 0;j < count;j++){
//             for(int i = 0;i < j;i++){
//                 int volume = Math.min(height[j],height[i]) * (j - i);
//                 maxVolume = Math.max(maxVolume,volume);
//             }
//         }
//         return maxVolume;
//     }
// }
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int res = 0;
        while(left < right){
            area = Math.min(height[left],height[right]) * (right - left);
            res = Math.max(area,res);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return res;
    }
}