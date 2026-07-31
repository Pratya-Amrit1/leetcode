class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cooklen=s.length-1;
        if(s.length==0)return 0;
        int childlen=g.length-1;
        Arrays.sort(s);
        Arrays.sort(g);
        int val=0;
        while(cooklen>=0 && childlen>=0){
          if(s[cooklen]>=g[childlen]){
            val++;
            cooklen--;
            childlen--;
          }
          else{
            childlen--;
          }
        }
        return val;
    }
}