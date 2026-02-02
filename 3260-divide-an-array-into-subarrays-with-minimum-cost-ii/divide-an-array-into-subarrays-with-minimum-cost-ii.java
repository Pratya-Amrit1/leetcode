class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        
        PriorityQueue<Integer> pq_left = new PriorityQueue<>((a, b)->b-a);
        PriorityQueue<Integer> pq_right = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        int valid_left = 0;
        long sum_left = 0;

        long res = Long.MAX_VALUE;

        for(int i=1; i<n; i++){
           
            if(i>=dist+2){
                int v = nums[i-dist-1]; 
                if(v<pq_left.peek()){
                    map.merge(v, 1, Integer::sum);
                    valid_left--;
                    sum_left -= v;
                }
                else if(v==pq_left.peek()){
                    pq_left.poll();
                    valid_left--;
                    sum_left -= v;
                }
                else if(v==pq_right.peek()){
                    pq_right.poll();
                }
                else{
                    map.merge(v, 1, Integer::sum);
                }
            }


            if(i<=k-1 || nums[i]<=pq_left.peek()){
                pq_left.offer(nums[i]);
                valid_left++;
                sum_left += nums[i];
            }
            else{
                pq_right.offer(nums[i]);
            }

            if(i>k-1){
                if(valid_left<k-1){
                    int v = pq_right.poll();
                    pq_left.offer(v);
                    valid_left++;
                    sum_left += v;
                }
                else if(valid_left>k-1){
                    int v = pq_left.poll();
                    valid_left--;
                    sum_left -= v;
                    pq_right.offer(v);
                }
            }


            while(!pq_left.isEmpty() && map.getOrDefault(pq_left.peek(), 0)>0){
                int v = pq_left.poll();
                map.merge(v, -1, Integer::sum);
            }
            while(!pq_right.isEmpty() && map.getOrDefault(pq_right.peek(), 0)>0){
                int v = pq_right.poll();
                map.merge(v, -1, Integer::sum);
            }

            if(i>=dist+1){
                res = Math.min(res, sum_left);
            }
        }
        return res+nums[0];
    }
}
