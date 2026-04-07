class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0;i < n;i++){
            int t = temperatures[i];
            while(!st.isEmpty() && temperatures[st.peek()]<t){
                ans[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}