class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count=0;
        int n=costs.length;
        Arrays.sort(costs);

        for(int i=0;i<n;i++){
            if(costs[i]<=coins){
                coins-=costs[i];
                count++;
            }
        }
        return count;
    }
}