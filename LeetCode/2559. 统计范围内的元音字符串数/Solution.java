
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] s = new int[words.length + 1];
        for(int i = 0;i < words.length;i++){
            char head = words[i].charAt(0);
            char tail = words[i].charAt(words[i].length() - 1);
            if((head == 'a' || head == 'e' || head == 'i' || head == 'o' || head == 'u' )&&( tail == 'a' || tail == 'e' || tail == 'i' || tail == 'o' || tail == 'u')){
                s[i+1] = s[i] + 1;
            }else{
                s[i+1] = s[i];
            }
        }
        for(int i = 0;i < queries.length;i++){
            ans[i] = s[queries[i][1]+1] - s[queries[i][0]];
        }
        return ans;
    }
}