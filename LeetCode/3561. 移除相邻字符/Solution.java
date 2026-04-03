class Solution {
    public String resultingString(String s) {
        char[] arr = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && (Math.abs(c-st.peek()) == 1 || Math.abs(c-st.peek()) == 25)){
                st.pop();
            }else{
                st.push(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}