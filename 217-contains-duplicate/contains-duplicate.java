class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ms= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            ms.add(nums[i]);
        }
        return (nums.length != ms.size());
    }
}