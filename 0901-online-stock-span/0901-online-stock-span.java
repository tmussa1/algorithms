class StockSpanner {
    
    private Stack<Integer> monoStack;
    
    private Map<Integer, Integer> nums;
    int index = 0;

    public StockSpanner() {
        this.monoStack = new Stack<>();
        monoStack.push(-1);
        this.nums = new HashMap<>();
        nums.put(-1, Integer.MAX_VALUE);
    }
    
    public int next(int price) {
        
        while(!monoStack.isEmpty() && price >= nums.get(monoStack.peek())){
            monoStack.pop();
        }
        
        int result = 1;
        
        if(!monoStack.isEmpty()){
            result = index - monoStack.peek();
        } 
        
        monoStack.push(index);
        nums.put(index++, price);
        
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */