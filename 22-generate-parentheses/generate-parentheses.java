class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> na = new ArrayList<String>();
        trans(na , 0 , 0,"",n);
        return na;
    }
    public void trans(List<String> na ,int left , int right, String s ,int n ){
        if(s.length()== n*2){
            na.add(s);
            return;
        }
        if(left< n){
            trans(na,left+1 ,right ,s+"(",n);
        }
        if(right<left){
            trans(na , left , right+1 , s+")", n);
        }
    }

}