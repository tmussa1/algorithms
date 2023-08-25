class MRUQueue {
    
    int [] nums;
    
    int n;
    
    public MRUQueue(int n) {
        
        this.nums = new int[n];
        
        for(int i = 0; i < n; i++){
            this.nums[i] = i + 1;
        }
        
        this.n = n;
    }
    
    public int fetch(int k) {
        
        int temp = nums[k - 1];
        
        for(int i = k; i < n; i++){
            nums[i - 1] = nums[i];
        }
        
        nums[n - 1] = temp;
        
        return temp;
    }
    
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */