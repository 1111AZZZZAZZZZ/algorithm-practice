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
    public int getDecimalValue(ListNode head) {
        ListNode p = head;
        int ans = 0;
        int cnt = 0;
        Deque<Integer> st = new ArrayDeque<>();
        while(p != null){
            int val = p.val;
            st.push(val);
            p = p.next;
        }
        p = head;
        while(!st.isEmpty()){
            int val = st.pop();
            ans += val * Math.pow(2,cnt);
            cnt++;
        }
        return ans;
    }
}