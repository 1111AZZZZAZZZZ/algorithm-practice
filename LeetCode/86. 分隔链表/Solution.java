class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode preHead = new ListNode();
    ListNode preTail = preHead;
    ListNode sufHead = new ListNode();
    ListNode sufTail = sufHead;
    while (head != null) {
      if (head.val >= x) {
        sufTail.next = head;
        sufTail = sufTail.next;
      } else {
        preTail.next = head;
        preTail = preTail.next;
      }
      head = head.next;
    }
    sufTail.next = null;
    preTail.next = sufHead.next;
    return preHead.next;
  }
}