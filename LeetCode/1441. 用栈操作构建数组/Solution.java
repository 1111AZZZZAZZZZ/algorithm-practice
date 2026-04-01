class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int cnt = 0;
        for(int i = 1;i <= n;i++){
            int num = target[cnt];
            ans.add("Push");
            if(num != i){
                ans.add("Pop");
            }else{
                cnt++;
            }
            if(cnt == target.length){
                break;
            }
        }
        return ans;
    }
}