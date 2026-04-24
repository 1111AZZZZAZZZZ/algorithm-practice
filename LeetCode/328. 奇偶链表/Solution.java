class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;
        int cnt = 0;
        while(head != null){
            cnt++;
            if(cnt % 2 == 0){
                evenTail.next = head;
                evenTail = evenTail.next;
            }else{
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
        }
        oddTail.next = evenHead.next;
        evenTail.next = null;
        return oddHead.next;
    }
}