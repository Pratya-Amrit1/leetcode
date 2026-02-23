class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> arr = new ArrayList<>();
        res(1, arr, new ArrayList<>(), k, n);
        return arr;
    }
    public void res(int idx, List<List<Integer>> arr, List<Integer> chk, int k, int n){
        if(chk.size()==k){
            if(n==0){
                arr.add(new ArrayList<>(chk));
            }
            return;
        }

        for(int i=idx; i<10; i++){
            chk.add(i);
            res(i+1, arr, chk, k, n-i);
            chk.remove(chk.size()-1);
        }
    }
}