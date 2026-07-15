class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int maxdepth=0;

        for(char c :s.toCharArray()){
            if(c=='('){
                depth++;
            }
            else if(c==')'){
                depth--;
            }
            else{
                continue;
            }
            maxdepth=Math.max(depth,maxdepth);
        }
        return maxdepth;
    }
}