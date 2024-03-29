class MovingAverage {

    private LinkedList<Integer> lst;
    private int size, currentSize;
        
    public MovingAverage(int size) {
        this.lst = new LinkedList<>();
        this.size = size;
        this.currentSize = 0;
    }
    
    public double next(int val) {
        
        this.lst.addLast(val);
        this.currentSize++;
        
        if(currentSize > size){
            this.lst.removeFirst();
        }
        
        int sum = this.lst.stream().reduce(0, Integer::sum);
        
        return (sum * 1.0) / lst.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */