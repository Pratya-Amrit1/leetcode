class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num= new ArrayList<>();
        int[] fact = new int[n+1];
         fact[0]=1;
         for(int i=1;i<=n;i++){
            fact[i]=fact[i-1]*i;
            num.add(i);
         }
         k--;
         return solve(n,k ,num,fact);
    }
    public String solve(int n ,int k,List<Integer> num,int[] fact){
        if(n==0)return "";
        int bl =fact[n-1];
        int idx = k/bl;
        int chose= num.get(idx);
        num.remove(idx);
        return chose+solve(n-1,k%bl,num,fact);
    }
}