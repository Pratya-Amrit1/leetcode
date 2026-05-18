class Solution {
    private static final int N = 50001;
    private static final boolean[] vis = new boolean[N];
    private static final int[] q = new int[N];
    private static final int[] nxt = new int[N];

    public static int minJumps(int[] arr) {
        final int n = arr.length;
        Arrays.fill(vis, 0, n, false);
        
        Map<Integer, Integer> dict = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            Integer head = dict.get(x);
            if (head == null) {
                nxt[i] = -1;
            } else {
                nxt[i] = head;
            }
            dict.put(x, i);
        }
        int front = 0;
        int back = 0;

        q[back++] = 0;
        vis[0] = true;
        
        for (int step = 0; front < back; step++) {
            int s = back - front;
            while (s-- > 0) {
                int cur = q[front++];
                
                if (cur == n - 1) {
                    return step;
                }
                
                // Option 1: Jump backward
                if (cur - 1 >= 0 && !vis[cur - 1]) {
                    q[back++] = cur - 1;
                    vis[cur - 1] = true;
                }
                
                // Option 2: Jump forward
                if (cur + 1 < n && !vis[cur + 1]) {
                    q[back++] = cur + 1;
                    vis[cur + 1] = true;
                }
                
                // Option 3: Jump to same value indices
                int x = arr[cur];
                Integer head = dict.get(x);
                if (head != null && head != -1) {
                    for (int idx = head; idx != -1; idx = nxt[idx]) {
                        if (!vis[idx]) {
                            q[back++] = idx;
                            vis[idx] = true;
                        }
                    }
                    dict.put(x, -1); 
                }
            }
        }
        return -1;
    }
}