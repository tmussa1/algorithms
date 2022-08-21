class RandomizedSet {
    
    Map<Integer, Integer> indexMap;
    List<Integer> numbers;
    Random random;

    public RandomizedSet() {
        this.indexMap = new HashMap<>();
        this.numbers = new ArrayList<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return false;
        }
        this.indexMap.put(val, numbers.size());
        this.numbers.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
            return false;
        }
        int currIndex = this.indexMap.get(val);
        int lastElement = this.numbers.get(this.numbers.size() - 1);
        this.numbers.set(currIndex, lastElement);
        this.indexMap.put(lastElement, currIndex);
        this.indexMap.remove(val);
        this.numbers.remove(this.numbers.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return this.numbers.get(this.random.nextInt(this.numbers.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */