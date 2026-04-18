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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = dummy;
        int[] cnt = new int[201];
        while(curr.next != null){
            if(cnt[curr.next.val+100]>=1){
                curr.next = curr.next.next;
            }else{
                cnt[curr.next.val+100] ++;
                curr = curr.next;
            }
        }
        return head;
    }
}