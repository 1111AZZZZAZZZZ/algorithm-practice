class Trie {

    private static class Node{
        Node[] son = new Node[26];
        boolean end = false;
    }
    private final Node root = new Node();
    public void insert(String word) {
        Node curr = root;
        for(char c:word.toCharArray()){
            int ind = c-'a';
            if(curr.son[ind] == null){
                curr.son[ind] = new Node();
            }
            curr = curr.son[ind];
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        return find(word)==2;
    }
    
    public boolean startsWith(String prefix) {
        return find(prefix) > 0;
    }
    private int find(String s){
        Node curr = root;
        for(char c:s.toCharArray()){
            int ind = c-'a';
            if(curr.son[ind] == null){
                return 0;
            }
            curr = curr.son[ind];
        }
        return curr.end?2:1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */