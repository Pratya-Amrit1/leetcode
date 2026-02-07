class Solution {
    public int minimumDeletions(String s) {
        int acount=0;
        int bcount=0;
        int mindel=s.length();
        for(char i:s.toCharArray()){
            if(i=='a'){
                acount++;
            }
        }
        for(char i:s.toCharArray()){
            if(i=='a'){
                acount--;
            }
            mindel=Math.min(mindel,acount+bcount);
             if(i=='b'){
                bcount++;
            }
        }
        return mindel;
    }
}