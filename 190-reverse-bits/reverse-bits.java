class Solution {
    public int reverseBits(int n) {
        
        // int result=0;
        // for( int i=0 ;i<32;i++){
        //     result<<=1;
        //     result|= (n &1);
        //     n>>>=1;
        // }
        // return result;

  long maxi = 1L << 31;  // 2^31
        int ans = 0;
        int count = 0;

        while (count < 32) {
            if ((n & 1) == 1) {
                ans += maxi;
            }
            n >>= 1;      // shift input right
            maxi >>= 1;   // shift target position
            count++;
        }

        return ans;
    }
}
