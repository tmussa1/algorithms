class TimeMap {
    
    private Map<String, TreeSet<TimeNode>> timeMapStore;

    public TimeMap() {
        this.timeMapStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        TimeNode node = new TimeNode();
        node.key = key;
        node.value = value;
        node.timestamp = timestamp;
        
        TreeSet<TimeNode> timeSet = timeMapStore.getOrDefault(key, new TreeSet<TimeNode>((a, b) -> b.timestamp - a.timestamp));
        
        timeSet.add(node);
        
        timeMapStore.put(key, timeSet);
    }
    
    public String get(String key, int timestamp) {
        
        if(!timeMapStore.containsKey(key)) return "";
            
        TreeSet<TimeNode> timeSet = timeMapStore.get(key);
        
        String value = "";
        
        Iterator<TimeNode> iterator = timeSet.iterator();
        
        while(iterator.hasNext()){
            
            TimeNode currentNode = iterator.next();
            
            if(currentNode.timestamp <= timestamp){
                value = currentNode.value;
                break;
            }
        }
        
        return value;
    }
    
    class TimeNode {
        String key;
        String value;
        int timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */