class MySolution {
    public boolean isPowerOfThree(int n) {
        if(n >= 27){
            for(int i = 0;i < Math.sqrt(n);i++){
                if(n == Math.pow(3,i)){
                    return true;
                }
            }
        }else{
            for(int i = 0;i < n;i++){
                if(n == Math.pow(3,i)){
                    return true;
                }
            }
        }
        return false;
    }
}