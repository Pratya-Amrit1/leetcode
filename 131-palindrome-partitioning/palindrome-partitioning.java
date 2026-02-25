class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(0,ans,path,s);
        return ans;
    }
    public void helper(int idx ,List<List<String>> ans , List<String> path,String s){
        if(idx==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<s.length();++i){
            if(pali(s,idx,i)){
                path.add(s.substring(idx,i+1));
                helper(i+1,ans,path,s);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean pali(String s,int str ,int end){
        while( str<=end){
            if(s.charAt(str++)!= s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}