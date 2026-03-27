class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long[] nxtSum = new long[53];
        long[] preSum = new long[53];
        for(int i = 0;i < 52;i++){
            nxtSum[i+1] = nxtSum[i] + nextCost[i%26];
            preSum[i+1] = preSum[i] + previousCost[i%26];
        }
        long ans = 0;
        for(int i = 0;i < s.length();i++){
            int x = s.charAt(i) - 'a';
            int y = t.charAt(i) - 'a';
            ans += Math.min(nxtSum[y<x?y+26:y]-nxtSum[x],preSum[(x<y?x+26:x)+1]-preSum[y+1]);
        }
        return ans;
    }
}