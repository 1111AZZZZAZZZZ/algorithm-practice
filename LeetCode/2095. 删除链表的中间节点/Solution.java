class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode rear = dummy;
        int cnt = 0;
        while(rear.next != null){
            cnt ++;
            if(cnt % 2 == 0){
                pre = pre.next;
            }
            rear = rear.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}