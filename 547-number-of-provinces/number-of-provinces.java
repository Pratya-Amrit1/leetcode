class Solution {
    void dfs(int node, ArrayList<ArrayList<Integer>> li, int[] vis){
        vis[node]=1;
        for(Integer it : li.get(node)){
            if(vis[it]==0){
                dfs(it,li,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int m=isConnected[0].length;
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> li= new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1 && i!=j){
                    li.get(i).add(j);
                    li.get(j).add(i);
                }
            }
        }
        int[] vis=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,li,vis);
                vis[i]=1;
            }
        }
        return cnt;
    }
}