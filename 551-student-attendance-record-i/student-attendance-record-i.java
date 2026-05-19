class Solution {
    public boolean checkRecord(String s) {
         int l = 0 ;
        int a = 0 ;
        for ( char i : s.toCharArray() ) {
            if ( i == 'P' ) {
                l = 0 ;
                continue ;
            }
            else if ( i == 'A' ) {
                a ++ ;
                l = 0 ;
            }
            else if ( i == 'L' ) {
                l ++ ;
            }
            if ( a == 2 ) {
                return false ;
            }
            if ( l == 3 ) {
                return false ;
            }
        }
        return true ;
    }
}