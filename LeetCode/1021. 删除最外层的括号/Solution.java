class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        int depth = 0;
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            st.push(c);
            if(st.peek() == '('){
                cnt++;
                if(cnt == 1){
                    st.pop();
                }
            }else{
                cnt--;
                if(cnt == 0){
                    st.pop();
                }
            }
        }
        StringBuffer sb = new StringBuffer(1);
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}