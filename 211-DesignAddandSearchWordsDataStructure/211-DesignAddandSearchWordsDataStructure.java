// Last updated: 9/14/2025, 9:57:40 PM
class WordDictionary {
    private static class Node {
        Node[] children = new Node[26];
        boolean isWord = false;
    }
    
    private final Node root = new Node();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) cur.children[idx] = new Node();
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }
    
    // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchFrom(root, word, 0);
    }
    
    private boolean searchFrom(Node node, String word, int pos) {
        if (node == null) return false;
        if (pos == word.length()) return node.isWord;
        
        char c = word.charAt(pos);
        if (c == '.') {
            // try all possible children
            for (Node child : node.children) {
                if (child != null && searchFrom(child, word, pos + 1)) return true;
            }
            return false;
        } else {
            int idx = c - 'a';
            return searchFrom(node.children[idx], word, pos + 1);
        }
    }
}
