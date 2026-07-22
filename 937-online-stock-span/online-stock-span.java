class pair{
    int val;
    int idx;
    pair(int val ,int idx){
        this.val=val;
        this.idx=idx;
    }
}
class StockSpanner {
    Stack<pair> st;
    int idx=-1;
    public StockSpanner() {
        st=new Stack<>();
        st.clear();
    }
    
    public int next(int price) {
        idx+=1;
        while(!st.isEmpty() && st.peek().val<= price){
            st.pop();
        }
        int ans=idx- (st.isEmpty() ?-1:st.peek().idx);
        st.push(new pair(price ,idx));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */