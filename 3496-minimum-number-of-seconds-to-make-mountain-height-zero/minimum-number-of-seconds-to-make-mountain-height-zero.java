class Solution {
    public boolean check(int mountainHeight, int[] workerTimes, long seconds){
        for(int i=0;i<workerTimes.length;i++){
            mountainHeight -= (int)((-1 + Math.sqrt(1 + 8L * seconds / workerTimes[i])) / 2);
            if(mountainHeight<=0) return true;
        } 
        return false;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low=1;
        long high=workerTimes[0] * (mountainHeight * (mountainHeight+1L))/2;
        while(low<high){
            long mid=low+(high-low)/2;
            if(check(mountainHeight,workerTimes,mid)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return high;
    }
}