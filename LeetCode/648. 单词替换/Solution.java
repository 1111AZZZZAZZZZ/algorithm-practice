class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String ans = "";
        String[] arr = sentence.split(" ");
        Trie trie = new Trie();
        for(String s:dictionary){
            trie.insert(s);
        }
        for(int i = 0;i < arr.length;i++){
            String s = arr[i];
            if(trie.find(s)==null){
                ans += s;
            }else{
                ans += trie.find(s);
            }
            if(i == arr.length-1){
                break;
            }
            ans += " ";
        }
        return ans;
    }
}
class Trie{
    class Node{
        Node[] son = new Node[26];
        String s;
    }
    Node root = new Node();
    void insert(String word){
        Node curr = root;
        for(char c:word.toCharArray()){
            c-='a';
            if(curr.son[c]== null){
                curr.son[c] = new Node();
            }
            curr = curr.son[c];
        }
        curr.s = word;
    }

    String find(String s){
        Node curr = root;
        for(char c:s.toCharArray()){
            c-='a';
            if(curr.son[c]== null){
                return null;
            }
            if(curr.son[c].s != null){
                return curr.son[c].s;
            }
            curr = curr.son[c];
        }
        return null;
    }
}