class Solution {
    public int minAddToMakeValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && st.peek()=='(' && c == ')'){
                st.pop();
            }else{
                st.push(c);
            }
        }
        return st.size();
    }
}