class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int a=-1;
        Map<Integer,Integer> mp =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            if(entry.getValue()>n/2){
                 a= entry.getKey();
            }
        }
        return a;
    }
}