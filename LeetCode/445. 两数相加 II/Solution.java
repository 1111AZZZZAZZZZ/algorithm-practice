class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverseOrder(addTwo(reverseOrder(l1),reverseOrder(l2),0));
    }
    public ListNode reverseOrder(ListNode l1){
        ListNode newL1 = new ListNode(0);
        while(l1 != null){
            ListNode nxt = l1.next;
            l1.next = newL1.next;
            newL1.next = l1;
            l1 = nxt;
        }
        return newL1.next;
    }
    public ListNode addTwo(ListNode l1, ListNode l2,int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        int s = carry;
        if(l1 != null){
            s += l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            s += l2.val;
            l2 = l2.next;
        }
        return new ListNode(s%10,addTwo(l1,l2,s/10));
    }
}