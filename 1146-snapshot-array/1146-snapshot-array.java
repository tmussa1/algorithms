class SnapshotArray {
        
    List<TreeMap<Integer, Integer>> map;
    
    int snapId, length;

    public SnapshotArray(int length) {
        
        this.snapId = 0;
        this.length = length;
        this.map = new ArrayList<>(length);
        
        for(int i = 0; i < length; i++){
            map.add(new TreeMap<Integer, Integer>());
        } 
    }
    
    public void set(int index, int val) {
        map.get(index).put(snapId, val);
    }
    
    public int snap() {
        ++this.snapId;
        return this.snapId - 1;
    }
    
    public int get(int index, int snap_id) {
        
        TreeMap<Integer, Integer> entries = map.get(index);
        
        Integer key = entries.floorKey(snap_id);
        
        return key == null ? 0 : entries.get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */