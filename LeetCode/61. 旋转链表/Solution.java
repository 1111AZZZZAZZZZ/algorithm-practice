class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    int n = k;
    int cnt = 0;
    ListNode dummy = new ListNode(0, head);
    ListNode left = dummy;
    ListNode right = dummy;
    while (right.next != null) {
      right = right.next;
      cnt++;
    }
    if (cnt == 0) {
      return head;
    }
    n = k % cnt;
    right = dummy;
    while (n-- > 0) {
      right = right.next;
    }
    while (right.next != null) {
      left = left.next;
      right = right.next;
    }
    right.next = dummy.next;
    ListNode newHead = left.next;
    left.next = null;
    return newHead;
  }
}