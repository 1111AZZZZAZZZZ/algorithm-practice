class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode cur = head.next;
        ListNode pre = head;
        while(cur != null){
            if(pre.val <= cur.val){
                pre = cur;
                cur = cur.next;
            }else{
                ListNode p = dummy;
                while(p.next != cur && p.next.val < cur.val){
                    p = p.next;
                }
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}