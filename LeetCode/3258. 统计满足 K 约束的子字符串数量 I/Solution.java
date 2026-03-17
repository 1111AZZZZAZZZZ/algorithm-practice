class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0;
        int left = 0;
        char[] c = s.toCharArray();
        int[] cnt = new int[2];
        if(k == 0){
            return 0;
        }
        for(int i = 0;i < s.length();i++){
            cnt[c[i]-'0'] ++;
            while(cnt[0] > k && cnt[1] > k && left <= i){
                cnt[c[left]-'0'] --;
                left++;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}