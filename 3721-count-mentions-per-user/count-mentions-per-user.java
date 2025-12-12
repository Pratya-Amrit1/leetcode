class Solution {
    // enum TYPE{
    //     MESSAGE(1),
    //     OFFLINE(0); // more prior

    //     private int priority;
    //     private TYPE(int priority){
    //         this.priority = priority;
    //     }
    //     private int getPriority(){
    //         return this.priority;
    //     }
    // }

    public void reloadOnline(PriorityQueue<int[]> pq , int curtime , Set onlineUsers){
        while(!pq.isEmpty() && pq.peek()[1]+60 <= curtime){
            int top[] = pq.poll();
            int offid = top[0];
            onlineUsers.add(offid);
        }
    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events,(a,b)-> {
            // if(Integer.parseInt(a.get(1))==Integer.parseInt(b.get(1))) return TYPE.valueOf(a.get(0)).getPriority() - TYPE.valueOf(b.get(0)).getPriority();

            if(Integer.parseInt(a.get(1))==Integer.parseInt(b.get(1))) return a.get(0).equals("OFFLINE") ? -1:1;
            return Integer.parseInt(a.get(1))-Integer.parseInt(b.get(1));
        });

        int allAdd = 0;
        Set<Integer> onlineUsers = new HashSet<>();
        for(int i=0;i<numberOfUsers;i++) onlineUsers.add(i);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        int ans[] = new int[numberOfUsers];

        for(List<String> eve:events){
            String m1 = eve.get(0);
            String m2 = eve.get(1);
            String m3 = eve.get(2);
            // System.out.println(m1+" "+m2+" "+m3);
            if(m1.equals("MESSAGE")){
                int curtime = Integer.parseInt(m2);
                if(m3.equals("ALL")){
                    allAdd++;
                    //for(int i=0;i<numberOfUsers;i++) ans[i]++;
                }
                else if(m3.equals("HERE")){
                    reloadOnline(pq, curtime, onlineUsers);
                    if(pq.isEmpty()) allAdd++;
                    else {
                        for(int x:onlineUsers){
                            ans[x]++;
                        }
                    }
                }
                else{
                    String[] idarr = m3.split(" ");
                    for(String ids:idarr){
                        int idx = Integer.parseInt(ids.substring(2,ids.length()));
                        ans[idx]++;
                    }
                }
            }
            else{
                int offtime = Integer.parseInt(m2);
                int offlineId = Integer.parseInt(m3);
                reloadOnline(pq, offtime, onlineUsers);
                onlineUsers.remove(offlineId);
                pq.offer(new int[]{ offlineId, offtime});
            }
        }
        for(int i=0;i<numberOfUsers;i++) ans[i]+=allAdd;
        return ans;
    }
}