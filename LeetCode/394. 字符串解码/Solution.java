class Solution {
    public String decodeString(String s) {
        return decode(s.toCharArray());
    }
    private int i = 0;
    private String decode(char[] s){
        int k = 0;
        StringBuffer sb = new StringBuffer(1);
        while(i < s.length){
            char c = s[i];
            i++;
            if(Character.isLetter(c)){
                sb.append(c);
            }else if(Character.isDigit(c)){
                k = k*10+(c-'0');
            }else if(c == '['){
                String t = decode(s);
                sb.repeat(t,k);
                k = 0;
            }else{
                break;
            }
        }
        return sb.toString();
    }
}