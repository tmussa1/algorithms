class BrowserHistory {
    
    Stack<String> back;
    Stack<String> forward;

    public BrowserHistory(String homepage) {
        this.back = new Stack<>();
        this.forward = new Stack<>();
        this.back.push(homepage);
    }
    
    public void visit(String url) {
        this.forward.clear();
        this.back.push(url);
    }
    
    public String back(int steps) {
        
        String url = "";
        
        while(!back.isEmpty() && steps >= 1){
            url = back.pop();
            forward.push(url);
            steps--;
        }
        
        if(back.isEmpty())
            back.push(forward.pop());
        
        return back.peek();
    }
    
    public String forward(int steps) {
        
        String url = "";
        
        while(!forward.isEmpty() && steps >= 1){
            url = forward.pop();
            back.push(url);
            steps--;
        }
        
        return back.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */