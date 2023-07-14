class MyHashMap {
    
    int [] values;
    
    public MyHashMap() {
        this.values = new int[1_000_001];
        Arrays.fill(this.values, -1);
    }
    
    public void put(int key, int value) {
        this.values[key] = value;
    }
    
    public int get(int key) {
        return this.values[key];
    }
    
    public void remove(int key) {
        this.values[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */