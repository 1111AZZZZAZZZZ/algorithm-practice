class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        char[] s = senate.toCharArray();
        Queue<Integer> qR = new ArrayDeque<>();
        Queue<Integer> qD = new ArrayDeque<>();
        for(int i = 0;i < n;i++){
            if(s[i] == 'R'){
                qR.offer(i);
            }else{
                qD.offer(i);
            }
        }
        while(!qD.isEmpty() && !qR.isEmpty()){
            int r = qR.poll();
            int d = qD.poll();
            if(r>d){
                qD.offer(n++);
            }else{
                qR.offer(n++);
            }
        }
        if(!qD.isEmpty()){
            return "Dire";
        }else{
            return "Radiant";
        }
    }
}