/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo=1;
        int hi=n;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(!isBadVersion(mid)){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        // ⛔ lo == hi → first bad version
        return lo;
    }
}