class Solution {
    public int maxDepth(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        int ans = 0;
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && c == ')'){
                st.pop();
            }else if(c == '('){
                st.push(c);
            }
            ans = Math.max(ans,st.size());
        }
        return ans;
    }
}