public class ZigzagIterator {
    
    List<Integer> v1, v2;
    
    int v1Index, v2Index;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        
        if(v1Index < v1.size() && v1Index < v2Index){
           int element = v1.get(v1Index);
           this.v1Index++;
           return element;
        }
        
        if(v2Index < v2.size() && v2Index < v1Index){
           int element = v2.get(v2Index);
           this.v2Index++;
           return element;
        }
        
        if(v1Index < v1.size()) {
           int element = v1.get(v1Index);
           this.v1Index++;
           return element;
        }
        
        int element = v2.get(v2Index);
        this.v2Index++;
        return element;
    }

    public boolean hasNext() {
        return v1Index < v1.size() || v2Index < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */