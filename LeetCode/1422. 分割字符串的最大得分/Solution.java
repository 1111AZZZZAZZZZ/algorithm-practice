class Solution {
    public int maxScore(String s) {
        int count1 = 0;
        int count = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i)=='1'){
                count1 ++;
            }
        }
        for(int i = 0;i < s.length() - 1;i++){
            if(s.charAt(i)=='0'){
                count1 ++;
            }else{
                count1 --;
            }
            count = Math.max(count1,count);
        }
        return count;
    }
}