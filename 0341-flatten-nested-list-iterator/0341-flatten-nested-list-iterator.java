/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    int index = 0;
    List<Integer> list;
    List<NestedInteger> nestedList;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.list = new ArrayList<>();
        this.flattenList(this.nestedList, this.list);
    }
    
    private void flattenList(List<NestedInteger> nestedList, List<Integer> list){
        
        for(NestedInteger nestedInteger: nestedList){
            if(nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            } else {
                flattenList(nestedInteger.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        
        if(!hasNext()) {
            return -1;
        }
        
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return this.index < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */