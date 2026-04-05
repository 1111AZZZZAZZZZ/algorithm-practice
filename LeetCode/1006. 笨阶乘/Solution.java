class Solution {
    public int clumsy(int n) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(n);
        int index = 0;
        int ans = 0;
        for(int i = n-1;i > 0;i--){
            if(index == 0){
                st.push(st.pop()*i);
            }else if(index == 1){
                st.push(st.pop()/i);
            }else if(index == 2){
                st.push(i);
            }else{
                st.push(-i);
            }
            index = (index+1)%4;
        }
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
}