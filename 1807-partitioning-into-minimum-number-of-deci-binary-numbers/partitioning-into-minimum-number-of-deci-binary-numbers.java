class Solution {
    public int minPartitions(String n) {
        int maxsum=0;
        if(n.length()==1)return n.charAt(0)-'0'; 
       for(int i=0;i<n.length();i++){
        maxsum=Math.max(maxsum,n.charAt(i)-'0');
       }
       return maxsum;
    }
}