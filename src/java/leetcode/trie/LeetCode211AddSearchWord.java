package leetcode.trie;

public class LeetCode211AddSearchWord {
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
                if (current.children[ch - 'a'] == null) {
                    current.children[ch - 'a'] = new TrieNode();
                }
                current = current.children[ch - 'a'];
            }
            current.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            return search(word, 0, current);
        }

        private boolean search(String word, int i, TrieNode current) {
            if(null ==current){
                return false;
            }
            if(i==word.length()){
                return current.isEnd;
            }

            char ch = word.charAt(i);
            if (ch == '.') {
                for (int k = 0; k < 26; k++) {
                    if (search(word,i+1,current.children[k]) ){
                        return true;
                    }
                }
            } else {
                 if(search(word, i + 1, current.children[ch - 'a'])){
                     return true;
                 }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("bad");
        trie.insert("dad");
        trie.insert("mad");
        trie.insert("pad");
        System.out.println(trie.search("bad"));
        System.out.println(trie.search(".ad"));
        System.out.println(trie.search("b.."));
        System.out.println(trie.search("b.e"));
    }
}
