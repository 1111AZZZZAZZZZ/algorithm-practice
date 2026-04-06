class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String s:tokens){
            if(s.equals("+")){
                st.push(st.pop()+st.pop());
            }else if(s.equals("-")){
                int surb = st.pop();
                st.push(st.pop()-surb);
            }else if(s.equals("*")){
                st.push(st.pop()*st.pop());
            }else if(s.equals("/")){
                int divid = st.pop();
                st.push(st.pop()/divid);
            }else{
                int num = 0;
                if(s.charAt(0)!='-'){
                    for(int i = 0;i < s.length();i++){
                        num *= 10;
                        num += s.charAt(i) - '0';
                    }
                    st.push(num);
                }else{
                    for(int i = 1;i < s.length();i++){
                        num *= 10;
                        num += s.charAt(i) - '0';
                    }
                    st.push(-num);
                }
            }
        }
        return st.pop();
    }
}