class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int pile:piles){
            q.add(pile);
        }
        while(k-->0){
            int temp = (int)Math.ceil((float)q.poll()/2);
            q.add(temp);
        }
        int ans = 0;
        while(!q.isEmpty()){
            ans += q.poll();
        }
        return ans;
    }
}