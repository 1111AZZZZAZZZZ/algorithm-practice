class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int num:nums){
            q.add((long)num);
        }
        int cnt = 0;
        while(q.peek()<k && q.size()>=2){
            long x = q.poll();
            long y = q.poll();
            q.add(Math.min(x, y) * 2 + Math.max(x, y));
            cnt ++;
        }
        return cnt;
    }
}