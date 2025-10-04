class Solution {
    public int reverseBits(int n) {
    int Num = 0;
    for(int i = 0; i < 32; i++) {
        Num = Num << 1;
        Num = Num + (n & 1);
        n = n >> 1;
    }
    return Num;
}
 }
