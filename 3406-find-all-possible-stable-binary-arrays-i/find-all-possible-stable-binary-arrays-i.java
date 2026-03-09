class Solution {
    int MOD = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        
        int[][][] dp = new int[201][201][2];
        
        // base case
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for( int onesLeft = 0; onesLeft <= one; onesLeft++ ) {
            for( int zeroesLeft = 0; zeroesLeft <= zero; zeroesLeft++ ) {

                if( onesLeft == 0 && zeroesLeft == 0 ) continue;

                int result = 0;

                for( int len = 1; len <= Math.min( zeroesLeft , limit ); len++ ) {
                    result = ( result + dp[onesLeft][zeroesLeft - len][0] ) % MOD;
                }
                dp[onesLeft][zeroesLeft][1] = result;

                result = 0;
                for( int len = 1; len <= Math.min( onesLeft , limit ); len++ ) {
                    result = ( result + dp[onesLeft - len][zeroesLeft][1] ) % MOD;
                }
                dp[onesLeft][zeroesLeft][0] = result;
            }
        }

        int startWithOne = dp[one][zero][0];
        int startWithZero = dp[one][zero][1];

        return ( startWithOne + startWithZero ) % MOD;

    }
}