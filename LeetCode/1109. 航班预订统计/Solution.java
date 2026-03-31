class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int[] d = new int[n+2];
        for(int[] booking:bookings){
            int first = booking[0];
            int last = booking[1];
            d[first] += booking[2];
            d[last+1] -= booking[2];
        }
        int s = 0;
        for(int i = 1;i < n+1;i++){
            int v = d[i];
            s += v;
            ans[i-1] = s;
        }
        return ans;
    }
}