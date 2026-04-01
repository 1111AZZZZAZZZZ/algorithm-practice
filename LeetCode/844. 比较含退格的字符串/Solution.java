class Solution {
    public boolean backspaceCompare(String s, String t) {
        int m = s.length();
        int n = t.length();
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        int cnt = 0;
        for(int i =  0;i < m;i++){
            if(s.charAt(i) == '#'){
                if(cnt>0){
                    cnt--;
                    list1.remove(cnt);
                } 
            }else{
                list1.add(s.charAt(i));
                cnt++;
            }
        }
        cnt = 0;
        for(int i =  0;i < n;i++){
            if(t.charAt(i) == '#'){
                if(cnt>0){
                    cnt--;
                    list2.remove(cnt);
                }
            }else{
                list2.add(t.charAt(i));
                cnt++;
            }
        }
        int l1 = list1.size();
        int l2 = list2.size();
        if(l1 != l2){
            return false;
        }
        for(int i = 0;i < l1;i++){
            if(!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }
}