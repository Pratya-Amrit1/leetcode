class Solution {
    public int leastInterval(char[] tasks, int n) {
       Map<Character,Integer> mp =new HashMap<>();
       for(char task: tasks){
        mp.put(task, mp.getOrDefault(task,0)+1);
       }
       PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
       for(int value : mp.values()){
        pq.offer(value);
       }
       int time=0;
       while(!pq.isEmpty()){
        List<Integer> temp=new ArrayList<>();

        int cycle=n+1;
        int i=0;
        while(i<cycle && !pq.isEmpty()){
            int cnt=pq.poll();
            cnt--;
            if(cnt>0){
                temp.add(cnt);
            }
            time++;
            i++;
        }
        for(int it:temp){
            pq.offer(it);
        }
        if(!pq.isEmpty()){
            time+=(cycle-i);
        }
       }
       return time;
    }
}