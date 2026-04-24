class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length);
    }
    public ListNode mergeKLists(ListNode[] lists,int i,int j) {
        int m = j-i;
        if(m == 0){
            return null;
        }
        if(m == 1){
            return lists[i];
        }
        ListNode left = mergeKLists(lists,i,i+m/2);
        ListNode right = mergeKLists(lists,i+m/2,j);
        return mergeTwo(left,right);
    }
    public ListNode mergeTwo(ListNode left,ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(left != null && right != null){
            if(left.val>=right.val){
                curr.next = right;
                right = right.next;
            }else{
                curr.next = left;
                left = left.next;
            }
            curr = curr.next;
        }
        curr.next = right == null?left:right;
        return dummy.next;
    }
}