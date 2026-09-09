class Solution {
    public long countCommas(long n) {
        long v=n;
        long total=0;
        long start=1000;
        int comma=1;
        while(start<=v){
            long end =start*1000-1;
            long count =Math.min(v,end)-start+1;

            if(count>0){
                total+=count*comma;
                
            }
            start *=1000;
            comma++;
        }
        return total;
    }
}