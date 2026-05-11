class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            Stack<Integer> st =new Stack<>();
            while(num>0){
                int a = num%10;
                st.push(a);
                num=num/10;

            }
            while(!st.isEmpty()){
                res.add(st.pop());
            }
        }
        int[] resu = new int[res.size()];
        for(int i=0;i<res.size();i++){
            resu[i] = res.get(i);
        }
        return resu;
        
    }
}