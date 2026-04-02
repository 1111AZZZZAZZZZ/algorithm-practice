class Solution {
    public String removeStars(String s) {
        StringBuffer sb = new StringBuffer(1);
        // List<Character> list = new ArrayList<>();
        int n = s.length();
        int cnt = 0;
        for(int i = 0;i < n;i++){
            if(s.charAt(i) != '*'){
                sb.append(s.charAt(i));
                cnt++;
            }else if(cnt>0){
                cnt--;
                sb.delete(cnt,cnt+1);
            }
        }
        return sb.toString();
    }
}