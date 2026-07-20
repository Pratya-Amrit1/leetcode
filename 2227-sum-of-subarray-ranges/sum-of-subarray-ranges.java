class Solution {
    public int[] nse(int [] arr){
        int n=arr.length;
        int[] nst= new int [n];
        Stack<Integer> st= new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            nst[i]=st.isEmpty() ? n: st.peek();
            st.push(i);
        }
        return nst;
    }
    public int[] pse(int[] arr){
        int n=arr.length;
        int[] pst=new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            pst[i]=st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
        return pst;
    }
    public int[] nge(int [] arr){
        int n=arr.length;
        int[] nst= new int [n];
        Stack<Integer> st= new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            nst[i]=st.isEmpty() ? n: st.peek();
            st.push(i);
        }
        return nst;
    }
    public int[] pge(int[] arr){
        int n=arr.length;
        int[] pst=new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            pst[i]=st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
        return pst;
    }
    private long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = nse(arr);
        int[] psee = pse(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = 1L * left * right;
            sum += freq * arr[i];
        }
        return sum;
    }

    // Function to compute sum of subarray maximums
    private long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] nge = nge(arr);
        int[] pgee = pge(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;
            long freq = 1L * left * right;
            sum += freq * arr[i];
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
    }
}