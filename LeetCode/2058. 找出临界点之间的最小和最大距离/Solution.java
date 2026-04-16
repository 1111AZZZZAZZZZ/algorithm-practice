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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode a = head,b = head.next,c = head.next.next;
        List<Integer> list = new ArrayList<>();
        int cnt = 2;
        while(c != null){
            if(a.val < b.val && c.val < b.val){
                list.add(cnt);
            }else if(a.val > b.val && c.val > b.val){
                list.add(cnt);
            }
            a = a.next;
            b = b.next;
            c = c.next;
            cnt ++;
        }
        if(list.size()<2){
            return new int[]{-1,-1};
        }
        int mn = Integer.MAX_VALUE;
        for(int i = 0;i < list.size()-1;i++){
            int num1 = list.get(i);
            int num2 = list.get(i+1);
            mn = Math.min(Math.abs(num1-num2),mn);
        }
        int mx = list.get(list.size()-1) - list.get(0);
        return new int[]{mn,mx};
    }
}