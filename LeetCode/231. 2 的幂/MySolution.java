class MySolution {
    public boolean isPowerOfTwo(int n) {
        if(n >= 100){
            for(int i = 0;i <= Math.sqrt(n);i++){
                if(Math.pow(2,i) == n){
                    return true;
                }
            }
        }else{
            for(int i = 0;i <= n;i++){
                if(Math.pow(2,i) == n){
                    return true;
                }
            }
        }
        
        return false;
    }
}