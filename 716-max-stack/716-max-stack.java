class MaxStack {

    private PriorityQueue<Integer> queue;
    private Stack<Integer> stack;
    
    public MaxStack() {
        this.queue = new PriorityQueue<>((a, b) -> b - a);
        this.stack = new Stack<>();
    }
    
    public void push(int x) {
        queue.offer(x);
        stack.push(x);
    }
    
    public int pop() {
        queue.remove(stack.peek());
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return queue.peek();
    }
    
    public int popMax() {
        
        int topElement = queue.peek();
        
        Stack<Integer> tempStack = new Stack<>();
        
        while(!stack.isEmpty() && stack.peek() != topElement){
            tempStack.push(stack.pop());
        }
        
        stack.pop();
        
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        
        return queue.poll();
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */