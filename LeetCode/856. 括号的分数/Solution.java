class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(c == '('){
                st.push(c);
            }else{
                char nc = st.pop();
                if(nc == '('){
                    st.push('1');
                }else{
                    int sum = nc - '0';
                    while((nc = st.pop())!='('){
                        sum += nc - '0';
                    }
                    st.push((char) ((sum << 1)+'0'));
                }
            }
        }
        int ans = 0;
        while(!st.isEmpty()){
            ans += st.pop()-'0';
        }
        return ans;
    }
}