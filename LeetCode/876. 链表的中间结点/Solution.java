class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode rear = dummy;
        int cnt = 0;
        while(rear.next != null){
            cnt++;
            if(cnt % 2 == 0){
                pre = pre.next;
            }
            rear = rear.next;
        }
        return pre.next;
    }
}