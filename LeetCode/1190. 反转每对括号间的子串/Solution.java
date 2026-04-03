class Solution {
    public String reverseParentheses(String s) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer(1);
        char[] c = s.toCharArray();
        for(int i = 0;i < c.length;i++){
            if(c[i]=='('){
                st.push(i);
            }else if(c[i] == ')'){
                reverse(c,st.pop(),i);
            }
        }
        StringBuffer ans = new StringBuffer(1);
        for(int i = 0;i < c.length;i++){
            if(c[i]!='(' && c[i]!=')'){
                ans.append(c[i]);
            }
        }
        
        return ans.toString();
    }
    private static void reverse(char[] c,int start,int end){
        // int mid = start + (start-end)/2;
        StringBuffer sb = new StringBuffer(1);
        for(int i = start;i <= end;i++){
            sb.append(c[i]);
        }
        sb.reverse();
        int cnt = 0;
        for(int i = start;i <= end;i++){
            c[i] = sb.toString().charAt(cnt);
            cnt++;
        }
        // return sb;
    }
}