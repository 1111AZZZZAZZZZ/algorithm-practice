class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int[] d = new int[102];
        d[0] = batteryPercentages[0];
        for(int i = 1;i < batteryPercentages.length;i++){
            int rear = batteryPercentages[i];
            int front = batteryPercentages[i-1];
            d[i] = rear - front;
        }
        int s = 0;
        for(int i = 0;i < 101;i++){
            int v = d[i];
            s += v;
            if(s > 0){
                d [i+1] --;
            }
        }
        s = 0;
        int ans = 0;
        for(int i = 0;i < batteryPercentages.length;i++){
            int v = d[i];
            s += v;
            if(s > 0){
                ans ++;
            }
        }
        return ans;
    }
}