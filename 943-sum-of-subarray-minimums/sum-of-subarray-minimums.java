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
    public int sumSubarrayMins(int[] arr) {
        int[] nst=nse(arr);
        int[] pst=pse(arr);
        long total =0;
        int n=arr.length;
        int mod=(int)(1e9+7);

        for(int i=0;i<n;i++){
            int left=i-pst[i];
            int right=nst[i]-i;
            total=(total+(left*right*1L*arr[i])%mod)%mod;
        }
        return (int)total;
    }
}