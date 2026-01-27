class Solution {
    public int distinctIntegers(int n) {
        int count = 1;
        for(int i =2;i<=n;i++){
            if(i%(i-1)==1){
                count++;
            }
        }
        return count;
    }
}