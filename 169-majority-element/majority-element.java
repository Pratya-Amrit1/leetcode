class Solution {
    public int majorityElement(int[] nums) {
    //     HashMap<Integer , Integer> mpp= new HashMap<>();
    //     for(int i=0;i<nums.length;i++){
    //         mpp.put(nums[i] ,mpp.getOrDefault(nums[i],0)+1 );
    //         if(mpp.get(nums[i]) >nums.length/2){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }
    //boyer moryee model

    int count=0 , candidate=0;

    for(int num :nums){
        if(count==0){
        candidate=num;
    }
    count+=(num == candidate)? 1 :-1;
    
}
return candidate;
        } }