package customDS;

public class TrieMain {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.children[ch-'a'] == null) {
                    current.children[ch-'a'] = new TrieNode();
                }
                current = current.children[ch-'a'];
            }
            current.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.children[ch-'a'] == null) {
                    return false;
                }
                current = current.children[ch-'a'];
            }
            return current.isEnd;
        }

        public boolean startsWith(String word){
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.children[ch-'a'] == null) {
                    return false;
                }
                current = current.children[ch-'a'];
            }
            return true;
        }

        public boolean delete(String word){
            TrieNode current = root;
            for(char ch : word.toCharArray()){
                if(current.children[ch-'a']==null){
                    return false;
                }
                current =  current.children[ch -'a'];
            }
            current.isEnd=false;
            return true;
        }


    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("deepak");
        System.out.println(trie.search("deep"));
        System.out.println(trie.search("deepak"));
        trie.insert("deep");
        System.out.println(trie.search("deep"));
        trie.delete("deepak");
        System.out.println(trie.search("deep"));
        System.out.println(trie.search("deepak"));
    }
}
