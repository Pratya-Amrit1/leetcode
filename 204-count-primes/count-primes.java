class Solution {
    public int countPrimes(int n) {
        int count=0;
        if(n==0 ||n==1|| n==2)return 0;
        if(n==3)return 1;
        boolean[] prime = new boolean[n];
        for (int i = 0; i < n; i++) {
            prime[i] = true;
        }
 
        for (int p = 2; p * p <n; p++) {
            if (prime[p]) {
               
                for (int i = p * p; i <n; i += p)
                    prime[i] = false;
            }
        }
 
       
        for (int p = 2; p < n; p++) {
            if (prime[p])
                count++;
        }
 
        return count;
    }
}