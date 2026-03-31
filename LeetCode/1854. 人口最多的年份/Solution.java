class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] d = new int[102];
        for(int[] log:logs){
            int birth = log[0];
            int death = log[1];
            d[birth-1950] ++;
            d[death-1950] --;
        }
        int s = 0;
        int p = 0;
        int ans = 0;
        for(int i = 0;i < 102;i++){
            int v = d[i];
            s += v;
            if(s > p){
                p = s;
                ans = i;
            }
        }
        return ans+1950;
    }
}