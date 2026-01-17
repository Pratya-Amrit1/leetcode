class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> s1 =new HashSet<>();
        Set<Integer> s2 =new HashSet<>();
        Set<Integer> s3 =new HashSet<>();
        for(int i :nums1){
            s1.add(i);
        }
        for(int i :nums2){
            s2.add(i);
        }
        for(int i :nums3){
            s3.add(i);
        }
        Map<Integer, Integer> mpp = new HashMap<>();
       for(int x :s1){
        mpp.put(x,mpp.getOrDefault(x,0)+1);
       }
       for(int x :s2){
        mpp.put(x,mpp.getOrDefault(x,0)+1);
       }
       for(int x :s3){
        mpp.put(x,mpp.getOrDefault(x,0)+1);
       }

       List<Integer> li =new ArrayList<>();
       for( int x :mpp.keySet()){
        if(mpp.get(x) >=2){
            li.add(x);
        }
       }
       return li;
    }
}