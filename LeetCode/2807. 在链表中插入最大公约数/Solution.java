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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while(curr.next != null){
            ListNode temp = gcd(curr,curr.next);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        return head;
    }
    public ListNode gcd(ListNode x,ListNode y){
        int a = x.val;
        int b = y.val;
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return new ListNode(a);
    }
}