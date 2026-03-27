class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuffer sb = new StringBuffer();
        long[] sum = new long[shifts.length+1];
        for(int i = s.length()-1;i >=0 ;i--){
            sum[i] = sum[i+1] + shifts[i];
        }
        for(int i = 0;i < s.length();i++){
            long num = s.charAt(i) - 'a' + sum[i];
            char c = (char)('a' + num%26);
            sb.append(c);
        }
        return sb.toString();
    }
}