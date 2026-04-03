class Solution {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && st.peek() == c){
                st.pop();
            }else{
                st.push(c);
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