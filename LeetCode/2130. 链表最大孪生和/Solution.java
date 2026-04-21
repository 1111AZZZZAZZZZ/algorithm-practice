class Solution {
    public int pairSum(ListNode head) {
        ListNode pre = head;
        ListNode rear = head;
        int cnt = 1;
        int p = 1;
        while(rear.next != null){
            cnt++;
            if(cnt % 2 == 0){
                pre = pre.next;
            }
            rear = rear.next;
        }
        int[] sum = new int[cnt/2];
        rear = head;
        for(int i = 0;i < cnt/2;i++){
            sum[i] += rear.val;
            sum[cnt/2-1-i] += pre.val;
            pre = pre.next;
            rear = rear.next;
        }
        Arrays.sort(sum);
        return sum[cnt/2-1];
    }
}