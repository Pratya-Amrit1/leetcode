class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n= players.length;
        int m = trainers.length;
        int l=0;
        int r=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(l<n && r<m){
            if(players[l]<=trainers[r]){
                l+=1;
            }
            r+=1;
        }
        return l;
    }
}