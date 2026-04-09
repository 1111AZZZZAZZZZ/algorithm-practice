class SmallestInfiniteSet {
    PriorityQueue<Integer> q;
    int[] arr;
    public SmallestInfiniteSet() {
        q = new PriorityQueue<>();
        arr = new int[1001];
        for(int i = 1;i <= 1000;i++){
            q.add(i);
        }
    }
    
    public int popSmallest() {
        int ans = q.poll();
        arr[ans] --;
        return ans;
    }
    
    public void addBack(int num) {
        if(arr[num]<0){
            q.add(num);
            arr[num]++;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */