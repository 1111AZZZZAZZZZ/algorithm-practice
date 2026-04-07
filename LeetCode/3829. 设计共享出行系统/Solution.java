class RideSharingSystem {
    Queue<Integer> qD;
    Queue<Integer> qR;
    public RideSharingSystem() {
        qD = new ArrayDeque<>();
        qR = new ArrayDeque<>();
    }
    
    public void addRider(int riderId) {
        qR.offer(riderId);
    }
    
    public void addDriver(int driverId) {
        qD.offer(driverId);
    }
    
    public int[] matchDriverWithRider() {
        int[] ans = new int[2];
        if(!qD.isEmpty() && !qR.isEmpty()){
            ans[0] = qD.poll();
            ans[1] = qR.poll();
        }else{
            Arrays.fill(ans,-1);
        }
        return ans;
    }
    
    public void cancelRider(int riderId) {
        Queue<Integer> temp = new ArrayDeque<>();
        while(!qR.isEmpty()){
            int curr = qR.poll();
            if(curr != riderId){
                temp.offer(curr);
            }
        }
        qR = temp;
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */