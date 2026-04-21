class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null  head.next == null){
            return head;
        }
        ListNode revHead = reverseList(head.next);
        ListNode tail = head.next;
        tail.next = head;
        head.next = null;
        return revHead;
    }
}