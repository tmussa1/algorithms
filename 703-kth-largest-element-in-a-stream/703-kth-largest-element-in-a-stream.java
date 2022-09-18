class KthLargest {

    private int k;
    private PriorityQueue<Integer> queue;
    
    public KthLargest(int k, int[] nums) {
        
        this.k = k;
        
        this.queue = new PriorityQueue<>((a, b) -> a - b);
        
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
            
           if(queue.size() > k){
            queue.poll();
           }
        }
    }
    
    public int add(int val) {
        
        queue.offer(val);
        
        if(queue.size() > k){
            queue.poll();
        }
        
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */