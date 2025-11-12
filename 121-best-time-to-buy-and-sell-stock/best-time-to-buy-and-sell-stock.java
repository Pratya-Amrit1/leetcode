// class Solution {
//     public int maxProfit(int[] prices) {
//         int buyprice= Integer.MAX_VALUE;
//         int maxprice=0;
//         for(int i=0;i<prices.length;i++){
//             if(buyprice<prices[i]){
//             int profit=prices[i]-buyprice;
//             maxprice= Math.max(maxprice,profit);
//             }
//             else{
//                 buyprice=prices[i];
//             }
//         }
//         return maxprice;
//     }
// }

class Solution {
    public int maxProfit(int[] P) {
        int mn = P[0], ans  = 0;
        for(int x: P) {
            mn = Math.min(mn, x);
            ans = Math.max(ans, x-mn);
        }
        return ans;
    }
}