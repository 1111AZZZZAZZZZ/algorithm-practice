class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int x:gifts){
            q.offer(x);
        }
        while(k-->0){
            int max=q.poll();
            q.offer((int)Math.sqrt(max));
        }
        long ans=0;
        while(!q.isEmpty()){
            ans+=(long)q.poll();
        }
        return ans;
    }
}