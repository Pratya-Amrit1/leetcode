class Solution {
    public int maxJumps(int[] arr, int d) {
        Integer[] dp = new Integer[arr.length];
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            if(dp[i] == null){
                dfs(i, d, arr, dp);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
//dfs used
    public int dfs(int idx, int d, int[] arr, Integer[] cache){
        if(cache[idx] != null){
            return cache[idx];
        }
        int res = 0;
        for(int i = idx + 1; i < Math.min(arr.length, idx + d + 1); i++){
            if(arr[i] >= arr[idx]){
                break;
            }
            res = Math.max(res, dfs(i, d, arr, cache));
        }
        for(int i = idx - 1; i >= Math.max(0, idx - d); i--){
            if(arr[i] >= arr[idx]){
                break;
            }
            res = Math.max(res, dfs(i, d, arr, cache));
        }
        return cache[idx] = 1 + res;
    }
}