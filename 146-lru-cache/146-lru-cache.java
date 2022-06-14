class LRUCache {
    
    private int capacity;
    private Map<Integer, Node> nodeMap;
    private Node lru;
    private Node mru;
    
    public LRUCache(int capacity) {
       this.capacity = capacity;
       this.nodeMap = new HashMap<>();
       this.lru = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
       this.mru = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
       this.mru.prev = lru;
       this.lru.next = mru;
    }
    
    private void insert(Node node){
        Node prev = mru.prev;
        node.prev = prev;
        node.next = mru;
        mru.prev = node;
        prev.next = node;
        this.nodeMap.put(node.key, node);
    }
    
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        
        if(this.nodeMap.containsKey(key)){
            Node node = this.nodeMap.get(key);
            remove(node);
            this.nodeMap.remove(key);
            insert(node);
            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(this.nodeMap.containsKey(key)){
           Node node = this.nodeMap.get(key);
           remove(node); 
           this.nodeMap.remove(key);
        }
        
        Node node = new Node(key, value);
        
        insert(node);
        
        if(this.nodeMap.size() > capacity){
            Node toDelete = this.lru.next;
            remove(toDelete);
            this.nodeMap.remove(toDelete.key);
        }
    }
    
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        
        Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */