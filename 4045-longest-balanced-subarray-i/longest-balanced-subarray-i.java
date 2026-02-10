// class Solution {
//     public int longestBalanced(int[] nums) {
//         int result=0;
//         for(int i=0;i<nums.length;i++){
//             Set<Integer> odd =new HashSet<>();
//             Set<Integer> even = new HashSet<>();
//             for(int j=i;j<nums.length;j++){
//                 if(nums[j] % 2 ==0) even.add(nums[j]);
//                 else{
//                     odd.add(nums[j]);
//                 }
//                 if(even.size()==odd.size()){
                    
//                 result = Math.max(result, j-i+1);
//                 }
//             }

//         }
//         return result;
//     }
// }

class Solution {
    public int longestBalanced(int[] nums) {
     int n=nums.length;
     int maxi=0;
     for(int i=0;i<n;i++){
        HashMap<Integer,Integer> hm=new HashMap<>();
        int evenc=0;
            int oddc=0;
        for(int j=i;j<n;j++){
            int x=nums[j];
            int count=hm.getOrDefault(x,0);
            hm.put(x,count+1);
            
            //for(int y:hm.keySet())
            if(count==0){
                if(x%2==0) evenc++;
                else oddc++;
            }
            if(evenc==oddc){
                maxi=Math.max(maxi,j-i+1);
            }
        }
     } 
     return maxi;  
    }
}