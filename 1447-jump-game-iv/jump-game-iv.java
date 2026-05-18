class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length, step = 0;
        if(n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.computeIfAbsent(arr[i], k->new ArrayList<>()).add(i);
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        
        q.offer(0);
        vis[0] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            step++;

            for(int i = 0; i < size; i++) {
                int curId = q.poll();

                int[] nextPos = {curId+1, curId-1};
                for(int nextId : nextPos) {
                    if(nextId == n-1) return step;
                    if(nextId >= 0 && nextId < n && !vis[nextId]) {
                        vis[nextId] = true;
                        q.offer(nextId); 
                    }
                }

                // All indices with the same value
                if(map.get(arr[curId]) != null) {
                    for(int nextId : map.get(arr[curId])){
                        if(nextId == n-1) return step;
                        if(!vis[nextId]) {
                            vis[nextId] = true;
                            q.offer(nextId);
                        }
                    }
                    map.remove(arr[curId]);
                }
            }
        }

        return step;
    }
}