class Solution2 {
    public List<String> partitionString(String s) {
        List<String> ans = new ArrayList<>();
        class Node{
            Node[] son = new Node[26];
        }
        Node root = new Node();
        Node curr = root;
        int left = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            c -= 'a';
            if(curr.son[c] == null){
                curr.son[c] = new Node();
                ans.add(s.substring(left,i+1));
                left = i+1;
                curr = root;
            }else{
                curr = curr.son[c];
            } 
        }
        return ans;
    }
}