class MyQueue {
    
    Stack<Integer> pushStack, popStack;

    public MyQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }
    
    public void push(int x) {
        this.pushStack.push(x);
    }
    
    public int pop() {
        
        if(popStack.isEmpty()){
            
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        
        return this.popStack.pop();
    }
    
    public int peek() {
        
        if(popStack.isEmpty()){
            
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        
        return this.popStack.peek();
    }
    
    public boolean empty() {
        return this.pushStack.isEmpty() && this.popStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */