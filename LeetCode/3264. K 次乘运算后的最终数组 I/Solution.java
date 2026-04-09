class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int[] ans = new int[n];
        // Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });
        for(int i = 0;i < n;i++){
            int num = nums[i];
            int[] ind = new int[2];
            ind[0] = i;
            ind[1] = num;
            q.add(ind);
        }
        while(k-->0){
            int mn = q.peek()[1];
            int i = q.poll()[0];
            q.add(new int[]{i,mn * multiplier});
        }
        while(!q.isEmpty()){
            int i = q.peek()[0];
            ans[i] = q.poll()[1];
        }
        return ans;
    }
}