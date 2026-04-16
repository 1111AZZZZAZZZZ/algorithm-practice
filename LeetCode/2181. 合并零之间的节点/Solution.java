/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode p = head.next;
        int sum = 0;
        ListNode newHead = new ListNode(sum);
        ListNode temp = newHead;
        while(p != null){
            sum += p.val;
            if(p.val == 0){
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            }
            p = p.next;
        }
        return newHead.next;
    }
}