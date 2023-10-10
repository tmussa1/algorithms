class RLEIterator {
    
    PriorityQueue<int []> queue;
    
    int count = 0;

    public RLEIterator(int[] encoding) {
        
        this.queue = new PriorityQueue<int[]>((a, b) -> {
            return a[0] - b[0];
        });
        
        int index = 0;
        
        while(index < encoding.length){
            
            int count = encoding[index], digit = encoding[index + 1];
            
            if(count == 0){
                index += 2;
                continue;
            }
            
            int [] curr = new int [3];
            curr[0] = index + 1;
            curr[1] = digit;
            curr[2] = count;
            
            queue.offer(curr);
            
            index += 2;
        }
    }
    
    public int next(int n) {
        
        count = 0;
        
        while(!queue.isEmpty() && count < n){
            
            int [] curr = queue.poll();
            count += curr[2];
            
            if(count >= n){
                if(count > n){
                    curr[2] = count - n;
                    queue.offer(curr);
                }
                return curr[1];
            }
        }
        
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */