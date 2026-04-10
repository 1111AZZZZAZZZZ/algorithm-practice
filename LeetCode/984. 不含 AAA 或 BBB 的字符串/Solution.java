class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuffer sb = new StringBuffer();
        while(a > 0 || b > 0){
            boolean flags = false;
            int l = sb.length();
            if(l>=2 && sb.charAt(l-1)==sb.charAt(l-2)){
                if(sb.charAt(l-1)=='b'){
                    flags = true;
                }
            }else{
                if(a>b){
                    flags = true;
                }
            }
            if(flags && a>0){
                sb.append('a');
                a--;
            }else if(b>0){
                sb.append('b');
                b--;
            }

        }
        // while(a-->0){
        //     sb.append('a');
        // }
        // while(b-->0){
        //     sb.append('b');
        // }
        return sb.toString();
    }
}