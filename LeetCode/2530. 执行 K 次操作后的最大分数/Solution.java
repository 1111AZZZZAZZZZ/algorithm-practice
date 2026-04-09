class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for(int num:nums){
            q.add(num);
        }
        while(k-->0){
            int point = q.poll();
            ans += point;
            point = (int)Math.ceil((double)point / 3);
            q.add(point);
        }
        return ans;
    }
}