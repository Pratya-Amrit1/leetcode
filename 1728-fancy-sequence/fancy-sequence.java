class Fancy {
    int MOD = 1000000007;
    ArrayList<Long> arr = new ArrayList<>();;
    long add  = 0;
    long mult = 1;

    private long power( long a, long b ) {
        if( b == 0 ) return 1;

        long half = power(a, b/2);
        long result = ( half * half ) % MOD;

        if( b % 2 == 1 ) {
            result = ( result * a ) % MOD;
        }

        return result;

    }

    public Fancy() {
    }
    
    public void append(int val) {
        long newVal = ( ( val - add ) % MOD + MOD ) * power( mult, MOD - 2 ) % MOD;
        arr.add(newVal);
    }
    
    public void addAll(int inc) {
        add = ( add + inc ) % MOD;
    }
    
    public void multAll(int m) {
        add  = ( add * m ) % MOD;
        mult = ( mult * m ) % MOD;
    }
    
    public int getIndex(int idx) {
        if( idx >= arr.size() ) return -1;

        return (int)( ( arr.get(idx) * mult + add ) % MOD ); 
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */