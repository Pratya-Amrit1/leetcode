class Solution {
    public long minNumberOfSeconds(int h, int[] t) {
        PriorityQueue<long[]>pq = new PriorityQueue<>(
            (a,b) ->Long.compare(a[0],b[0])
        );
        for(int i = 0; i<t.length;i++){
            pq.add(new long[]{t[i],i,1});
        }
        long res = 0;
        while(h>0){
            long[] curr =pq.poll();

            long tm = curr[0];
            int id = (int)curr[1];
            int x = (int)curr[2];

            res = tm;
            h--;

            if(h>0){
                long nx = x+1;
                long nt = (long)t[id] * (nx *(nx+1)/2);
                pq.add(new long[]{nt ,id,nx});

            }
        }
        return res;
    }
}