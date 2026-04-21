class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = head;
        ListNode newTail = head;
        for(int i = 1;i  right;i ++){
            if(ileft){newHead = newHead.next;}
            newTail = newTail.next;
        }
        int mid = right - left;
        if(newHead != null && mid = 0){
            mid --;
            return newHead;
        }
    }
}