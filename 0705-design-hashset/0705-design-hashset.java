class MyHashSet {
    
    
    int [] values;

    public MyHashSet() {
        this.values = new int[1_000_001];
        Arrays.fill(this.values, -1);
    }
    
    public void add(int key) {
        values[key] = key;
    }
    
    public void remove(int key) {
        values[key] = -1;
    }
    
    public boolean contains(int key) {
        return this.values[key] != -1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */