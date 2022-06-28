class TwoSum {

    private List<Integer> store;
    
    public TwoSum() {
        this.store = new ArrayList<>();
    }
    
    public void add(int number) {
        this.store.add(number);
    }
    
    public boolean find(int value) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < this.store.size(); i++){
            
            int complement = value - store.get(i);
            
            if(set.contains(complement)){
                return true;
            } else {
                set.add(store.get(i));
            }
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */