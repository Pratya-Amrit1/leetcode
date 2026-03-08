class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxi=0;
        int justmax=0;
        for(int i=0;i<accounts.length;i++){
            for(int j=0;j<accounts[0].length;j++){
                justmax+=accounts[i][j];
            }
            maxi=Math.max(maxi,justmax);
            justmax=0;
        }
    return maxi;
    }
}