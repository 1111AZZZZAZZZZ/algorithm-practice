class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            q.add(stone);
        }

        while(q.size()>1){
            int max = q.poll();
            int second = q.poll();
            if(max != second){
                q.add(max - second);
            }
        }
        if(q.size()>0){
            return q.poll();
        }
        return 0;
    }
}