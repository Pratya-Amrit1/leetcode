class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int c= (int)(Math.floor((purchaseAmount+5)/10)*10);
        return (100-c);
    }
}