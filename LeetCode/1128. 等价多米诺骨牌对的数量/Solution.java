import java.util.*;
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        Map<List<Integer>,Integer> map = new HashMap<>();
        for(int i = 0;i < dominoes.length;i++){
            int[] dominoe = dominoes[i];
            Arrays.sort(dominoe);
            List<Integer> list = new ArrayList<>();
            list.add(dominoe[0]);
            list.add(dominoe[1]);
            if(map.containsKey(list)){
                ans += map.get(list);
            }
            map.put(list,map.getOrDefault(list,0)+1);
        }
        return ans;
    }
}