class Solution {
    public int passwordStrength(String password) {
        String s= password;
        Set<Character> ds=new HashSet<>();
        for(int i=0;i<s.length();i++){
            ds.add(s.charAt(i));
        }
        int total=0;

        for(char ch:ds){
            if(ch>='a' && ch<='z'){
                total+=1;
            }
            else if(ch>='A' && ch<='Z'){
                total+=2;
            }else if(ch>='0' && ch<='9'){
                total+=3;
                
            }
            else if(ch=='!' ||ch == '@' || ch == '#' || ch == '$'){
                total+=5;
            }
        }
        return total;
    }
}