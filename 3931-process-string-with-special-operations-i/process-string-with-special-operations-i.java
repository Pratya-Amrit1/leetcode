class Solution {
    public String processStr(String s) {
        StringBuilder st=new StringBuilder();
        for( char c:s.toCharArray()){
            if(c=='#'){
                st.append(st);
            }
            else if(c=='%'){
                st.reverse();
            }
            else if(c=='*'){
                if(st.length()>0)
                st.deleteCharAt(st.length()-1);
            }
            else{
                st.append(c);
            }
        }
        return st.toString();
    }
}