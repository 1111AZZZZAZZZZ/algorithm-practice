class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int left = 0;
        char[] c = s.toCharArray();
        int[] cnt = new int[3];
        for(int i = 0;i < c.length;i++){
            cnt[c[i] - 'a'] ++;
            while(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0 && left < i){
                cnt[c[left] - 'a'] --;
                left ++;
            }
            ans += left;
        }
        return ans;
    }
}