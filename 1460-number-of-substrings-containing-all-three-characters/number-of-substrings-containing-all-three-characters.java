class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastsum = {-1 ,-1 , -1} ;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            lastsum[c -'a'] =i;
            if(lastsum[0] !=-1 && lastsum[1] !=-1 && lastsum[2] !=-1){
                cnt =cnt+( 1+ Math.min(lastsum[0], Math.min(lastsum[1],lastsum[2])));
            }
        }
        return cnt;
    }
}