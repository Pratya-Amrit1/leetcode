class WordDictionary {
    class TrieNode{
            TrieNode[]children;
            boolean eow;
            public TrieNode(){
                children=new TrieNode[26];
                eow=false;
            }
        }
        private TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr=root;
        for(int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.eow=true;
    }
    
    public boolean search(String word) {
        return searchHelper(word,0,root);
    }
    public boolean searchHelper(String word,int index,TrieNode node){
        for(int i=index; i<word.length(); i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TrieNode child:node.children){
                    if(child!=null && searchHelper(word,i+1,child)){
                        return true;
                    }
                }
                return false;
            }    else{
                    if(node.children[c-'a']==null){
                        return false;
                    }
                    node=node.children[c-'a'];
                }
            

        }
        return node.eow;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
