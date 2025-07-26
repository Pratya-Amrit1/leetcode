class Solution {
    public int removeElement(int[] nums, int val) {
       //modify the array in place
        //we will be using two pointer to solve it
        int k=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i] !=val){
                nums[k++]=nums[i];
            }
        }
        return k;
    }
}