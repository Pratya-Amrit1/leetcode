class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
          Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
          int cnt=1;
          int lastend= intervals[0][1];
          int n= intervals.length;

          for(int i=0;i<n;i++){
            if(intervals[i][0]>= lastend){
                cnt=cnt+1;
                lastend=intervals[i][1];
            }
          }
          return n-cnt;
    }
}