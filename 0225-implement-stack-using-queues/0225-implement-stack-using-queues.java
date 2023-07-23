class MyStack {
    
    LinkedList<Integer> queue1, queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        
        while(!queue1.isEmpty()){
            queue2.offerFirst(queue1.poll());
        }
        
        return queue2.poll();
    }
    
    public int top() {
        
        while(!queue1.isEmpty()){
            queue2.offerFirst(queue1.poll());
        }
        
        
        return queue2.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */