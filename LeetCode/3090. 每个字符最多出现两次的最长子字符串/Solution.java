class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int left = 0;
        char[] c = s.toCharArray();
        char[] cnt = new char[26];
        for(int i = 0;i < c.length;i++){
            cnt[c[i] - 'a'] ++;
            while(cnt[c[i] - 'a'] > 2){
                cnt[c[left] - 'a'] --;
                left ++;
            }
            ans = Math.max(ans,i - left + 1);
        }
        return ans;
    }
}
