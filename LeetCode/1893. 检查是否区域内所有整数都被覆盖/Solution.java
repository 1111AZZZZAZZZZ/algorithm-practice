class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] d = new int[52];
        for(int[] range:ranges){
            int start = range[0];
            int end = range[1];
            d[start] ++;
            d[end+1] --;
        }
        int s = 0;
        for(int i = 0;i <= right;i++){
            int v = d[i];
            s += v;
            if(i>=left && s<=0){
                return false;
            }
        }
        return true;
    }
}