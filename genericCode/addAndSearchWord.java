/*
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 */



package genericCode;


class TrieNode
{
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c)
    {
        TrieNode node = new TrieNode();
        node.val = c;
        
    }
}
class WordDictionary {
    
    private TrieNode root;
    

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
        root.val =' ';
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        TrieNode crawler = root;
        
        for(int i =0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(crawler.children[c-'a']==null)
            {
                crawler.children[c-'a'] = new TrieNode(c);
            }
            crawler = crawler.children[c-'a'];
            
        }
        crawler.isWord =true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
        
    }
    
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return node.isWord;   
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


public class addAndSearchWord {

	public static void main(String[] args) {
		
		WordDictionary obj = new WordDictionary();
		obj.addWord("at");
		obj.addWord("and");
		obj.addWord("an");
		obj.addWord("add");
		System.out.print(obj.search("a"));
		// TODO Auto-generated method stub

	}

}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
