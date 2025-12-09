class Solution {
    public int finddays(int[] weights,int cap){
        int days=1;
        int load=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+load>cap){
            days+=1;
            load=weights[i];
            }
        else{
            load+=weights[i];
        }}
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while(left<=right){
            int mid=left+(right -left)/2;
            int numberofdays=finddays(weights ,mid);
            if(numberofdays<=days){
                right=mid-1;

            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

}