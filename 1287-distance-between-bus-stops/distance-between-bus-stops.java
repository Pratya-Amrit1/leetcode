// class Solution {
//     public int distanceBetweenBusStops(int[] nums, int start, int destination) {
//         int countersum=0;
//         int anticlock=0;
//         int res=0;
//         if(start>destination){
//            for(int i=destination;i<start;i++){
//             countersum +=nums[i];
//         }}
//         else{
//         for(int i=start;i<destination;i++){
//             countersum  +=nums[i];
//         }}
//          if(start>destination){
//            for(int i=start;i<nums.length;i++){
//             anticlock +=nums[i];
//         }}
//         else{
//         for(int i=nums.length-1;i>=destination;i--){
//             anticlock +=nums[i];
//         }
//         }
//         res= Math.min(countersum,anticlock);
//         return res;
//     }
// }

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;;
        }
        int res = 0, total = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                res += distance[i];
            }
            total += distance[i];
        }
        return Math.min(res, total - res);
    }
}