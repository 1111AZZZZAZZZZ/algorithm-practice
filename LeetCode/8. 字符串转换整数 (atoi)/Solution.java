class Solution {
    public int myAtoi(String s) {
        if(s.length()==0){
            return 0;
        }
        int i = 0;
        char c = s.charAt(i);
        boolean haveDigit = false;
        while((c == ' ')&& i < s.length()-1){
            i++;
            c = s.charAt(i);
        }
        long ans = 0;
        boolean falgs = false;
        boolean have = false;
        boolean haveNot0 = false;
        int cnt = 0;
        for(;i < s.length();i++){
            c = s.charAt(i);
            if(!have && c == '-'){
                if(haveDigit){
                    break;
                }
                falgs = true;
                have = true;
            }else if(Character.isDigit(c)){
                ans = ans*10+(c-'0');
                haveDigit = true;
                if(c != '0'){
                    haveNot0 = true;
                }
                if(haveNot0){
                    cnt++;
                }
                if(cnt > 10){
                    if(falgs){
                        ans = -(long)Math.pow(2,31);
                    }else{
                        ans = (long)Math.pow(2,31)-1;
                    }
                    return (int)ans;
                }
            }else if(!have && c == '+'){
                have = true;
                if(haveDigit){
                    break;
                }
            }else{
                break;
            }
        }
        if(falgs){
            ans = -ans;
        }
        if(ans<-Math.pow(2,31)){
            ans = -(long)Math.pow(2,31);
        }
        if(ans>Math.pow(2,31)-1){
            ans = (long)Math.pow(2,31)-1;
        }
        return (int)ans;
    }
}