class Solution {
    public boolean hasSameDigits(String s) {
        if(s.length()==2){
            if(s.charAt(0)== s.charAt(1))return true;
            else return false;
        }
        while(s.length()>2){
        StringBuilder st = new StringBuilder();
        for(int i=0;i<s.length()-1;i++){
            int digit =s.charAt(i)-'0';
            int digit2 = s.charAt(i+1)-'0';
            int sum =(digit+digit2)%10;
            st.append(sum);
        }
        s = st.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}