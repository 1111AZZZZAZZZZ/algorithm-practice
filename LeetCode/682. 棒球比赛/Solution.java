class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0;i < n;i++){
            char[] cs = operations[i].toCharArray();
            char s = cs[0];

            if(s=='+'){
                list.add(list.get(cnt-1)+list.get(cnt-2));
                cnt++;
            }else if(s=='D'){
                list.add(list.get(cnt-1)*2);
                cnt++;
            }else if(s=='C'){
                cnt--;
                list.remove(cnt);
            }else{
                int num = 0;
                int size = cs.length;
                boolean flags = false;
                for(int j = 0;j < size;j++){
                    s = cs[j];
                    if(s == '-'){
                        flags = true;
                    }else{
                        num *= 10;
                        num += s - '0';
                    }
                }
                if(flags){
                    list.add(-num);
                    cnt++;
                }else{
                    list.add(num);
                    cnt++;
                }
            }
        }
        int ans = 0;
        for(int i = 0;i < list.size();i++){
            ans += list.get(i);
        }
        return ans;
    }
}