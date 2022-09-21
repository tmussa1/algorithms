class HitCounter {
    
    TreeMap<Integer, Integer> hitMap;

    public HitCounter() {
        this.hitMap = new TreeMap<>();
    }
    
    public void hit(int timestamp) {
        hitMap.put(timestamp, hitMap.getOrDefault(timestamp, 0) + 1);
    }
    
    public int getHits(int timestamp) {
        
        Integer higherEntry = hitMap.floorKey(timestamp);
        Integer lowerEntry = hitMap.ceilingKey(timestamp - 299);
        
        if(lowerEntry == null){
            lowerEntry = timestamp - 299;
        }
        
        int result = 0;
        
        for(Map.Entry<Integer, Integer> entry: hitMap.entrySet()){
            if(entry.getKey() >= lowerEntry && entry.getKey() <= higherEntry){
                result += entry.getValue();
            }
        }
        
        return result;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */