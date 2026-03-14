class MySolution {
    public int maxScore(String s) {
        char[] c = s.toCharArray();
        int count = 0;
        int max = 0;
        for(int midR = 1;midR <c.length;midR++){
            count = 0;
            for(int i = 0;i < c.length;i++){
                if(i < midR && c[i] - '0' == 0){
                    count ++;
                }else if (i >= midR && c[i] - '1' == 0){
                    count ++;
                }
            }
            max = Math.max(count,max);
        }
        return max;
    }
}