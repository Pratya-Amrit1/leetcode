class Solution {
    public String generateTheString(int n) {
        StringBuilder st = new StringBuilder();
        if(n%2==0){
            for(int i=0;i<n-1;i++){
               st.append("a"); 
            }
            st.append("b");
        }else{
            for(int i=0;i<n;i++){
               st.append("a"); 
            }
        }
        return st.toString();
    }
}