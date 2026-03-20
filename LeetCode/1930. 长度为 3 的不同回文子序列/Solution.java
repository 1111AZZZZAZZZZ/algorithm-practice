class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        for (int c = 0; c < 26; c++) {
            if (first[c] == -1 || first[c] == last[c]) continue;
            boolean[] seen = new boolean[26];
            for (int i = first[c] + 1; i < last[c]; i++) {
                seen[s.charAt(i) - 'a'] = true;
            }
            for (boolean b : seen) {
                if (b) ans++;
            }
        }

        return ans;
    }
}
