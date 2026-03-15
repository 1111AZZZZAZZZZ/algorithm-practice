public class Solution {
  public int maxVowels(String s, int k) {
    int vowel = 0;
    int ans = 0;
    char[] c = s.toCharArray();
    for(int i = 0;i < s.length();i++){
      if(c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u'){
        vowel++;
      }
      int left = i - k + 1;
      if(left < 0){
        continue;
      }
      ans = Math.max(ans,vowel);
      if(ans == k){
        break;
      }
      if(c[left] == 'a' || c[left] == 'e' || c[left] == 'i' || c[left] == 'o' || c[left] == 'u'){
        vowel--;
      }
    }
    return  ans;
  }
}
