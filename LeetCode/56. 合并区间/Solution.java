class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(p,q)->p[0]-q[0]);
        List<int[]> ans = new ArrayList<>();
        for(int i = 0;i < intervals.length;i++){
            int m = ans.size();
            if(m>0 && ans.get(m-1)[1]>=intervals[i][0]){
                ans.get(m-1)[1] = Math.max(intervals[i][1],ans.get(m-1)[1]);
            }else{
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}