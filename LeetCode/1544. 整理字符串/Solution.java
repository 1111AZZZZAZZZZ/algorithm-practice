class Solution {
    public String makeGood(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && (c+32 == st.peek() || c-32 == st.peek())){
                st.pop();
            }else{
                st.push(c);
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop()+ans;
        }
        return ans;
    }
}