class RecentCounter {
    
    TreeSet<Integer> pings;

    public RecentCounter() {
        this.pings = new TreeSet<>((a, b) -> b - a);
    }
    
    public int ping(int t) {
        
        pings.add(t);
        
        Iterator<Integer> iter = pings.iterator();
        
        int last = t - 3000, result = 0;
        
        while(iter.hasNext()){
            int curr = iter.next();
            if(curr < last){
                break;
            }
            result++;
        }
        
        return result;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */