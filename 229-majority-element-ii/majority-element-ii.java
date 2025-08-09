class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // int n= nums.length;
        // List<Integer> fina =new ArrayList<>();
        // Arrays.sort(nums);
        // for(int i=0;i<n;i++){
        // int cnt=0;
        //     for(int j=1;j<n;j++){
        //         if(nums[i]==nums[j]){
        //             cnt++;
        //         }
        //     if(cnt> n/3){
        //         fina.add(nums[i]);
        //     }
        //     }
        // }
        // return fina;
         int n= nums.length;
        Map<Integer , Integer> majormap= new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i : nums){
            majormap.put(i , majormap.getOrDefault(i ,0)+1);
            if(majormap.get(i) > n/3 && !result.contains(i)){
                result.add(i);
            }
        }
        return result;

    }
}