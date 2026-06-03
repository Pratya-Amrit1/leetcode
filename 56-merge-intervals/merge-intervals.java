class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>>list1 = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                ArrayList<Integer>list=new ArrayList<>();
                list.add(start);
                list.add(end);
                list1.add(list);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        list.add(start);
        list.add(end);
        list1.add(list);
        // yaha convert to array
        int [][] result = new int [list1.size()][2];
        for(int i=0;i<list1.size();i++){
            result[i] = new int[]{list1.get(i).get(0), list1.get(i).get(1)};
        }
        return result;
    }
}