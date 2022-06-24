class MyCalendar {

    PriorityQueue<int []> queue;
    
    public MyCalendar() {
        this.queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        
        boolean result = true;
        
        if(!queue.isEmpty()){
            
            Queue<int []> tempQueue = new LinkedList<>();
            
            while(!queue.isEmpty()){
                
                int [] topQueue = queue.poll();
                
                if(start >= topQueue[0] && start < topQueue[1]){
                    result = false;
                }
                
                if(topQueue[0] >= start && topQueue[0] < end){
                    result = false;
                }
                
                tempQueue.offer(topQueue);
            }
            
            while(!tempQueue.isEmpty()){
                queue.offer(tempQueue.poll());
            }
        }
        
        if(result == true){
            int [] insert = new int[2];
            insert[0] = start;
            insert[1] = end;

            queue.offer(insert);
        }
        
        
        return result;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */