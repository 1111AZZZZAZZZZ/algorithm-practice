import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0;i < strs.length;i++){
            final char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(!map.containsKey(s)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s,list);
            }else{
                map.get(s).add(strs[i]);
            }
        }
        map.forEach((key,value)->{
            res.add(value);
        });
        return res;
    }
}