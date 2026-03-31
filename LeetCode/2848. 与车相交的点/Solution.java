class Solution {
    public int numberOfPoints(ListListInteger nums) {
        int[] d = new int[102];
        for(ListInteger list  nums){
            int start = list.get(0);
            int end = list.get(1);
            d[start] ++;
            d[end+1] --;
        }
        int ans = 0;
        int s = 0;
        for(int v  d){
            s += v;
            if(s0){
                ans++;
            }
        }
        return ans;
    }
}