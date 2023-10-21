class FreqStack {
    
    Map<Integer, Integer> freqMap;
    
    PriorityQueue<int []> queue;
    
    int index = 1;

    public FreqStack() {
        
        this.freqMap = new HashMap<>();
        
        this.queue = new PriorityQueue<int []>((a, b) -> {
            
          if(a[1] == b[1]) {
            return b[2] - a[2];
          }

           return b[1] - a[1];
        });
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        queue.add(new int [] {val, freqMap.get(val), index++});
    }
    
    public int pop() {
        
        int [] curr = queue.poll();
        
        int val = curr[0];
        
        freqMap.put(val, freqMap.get(val) - 1);
        
        if(freqMap.get(val) == 0){
            freqMap.remove(val);
        }
        
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */