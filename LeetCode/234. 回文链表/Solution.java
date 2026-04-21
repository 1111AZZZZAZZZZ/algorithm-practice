class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode rear = dummy;
        int cnt = 0;
        Deque<Integer> st = new ArrayDeque<>();
        while(rear.next != null){
            cnt ++;
            if(cnt % 2 == 0){
                pre = pre.next;
                st.push(pre.val);
            }
            rear = rear.next;
        }
        if(cnt == 1){
            return true;
        }
        if(cnt % 2 == 0){
            while(pre.next != null){
                if(pre.next.val != st.pop()){
                    return false;
                }
                pre = pre.next;
            }
            return true;
        }else{
            while(pre.next.next != null){
                if(pre.next.next.val != st.pop()){
                    return false;
                }
                pre = pre.next;
            }
            return true;
        }
    }
}