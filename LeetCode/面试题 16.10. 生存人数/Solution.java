class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] d = new int[102];
        for(int i = 0;i < birth.length;i++){
            int bir = birth[i];
            int dea = death[i];
            d[bir-1900] ++;
            d[dea-1900+1] --;
        }
        int s = 0;
        int mx = 0;
        int ans = 0;
        for(int i = 0;i < 102;i++){
            int v = d[i];
            s += v;
            if(s>mx){
                mx = s;
                ans = i;
            }
        }
        return ans+1900;
    }
}