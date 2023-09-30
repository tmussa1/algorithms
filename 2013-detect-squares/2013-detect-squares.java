class DetectSquares {
    
    Map<Pair<Integer,Integer>, Integer> coordinateMap;
    
    List<Pair<Integer,Integer>> points;

    public DetectSquares() {
        this.coordinateMap = new HashMap<>();
        this.points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(point[0], point[1]);
        coordinateMap.put(pair, coordinateMap.getOrDefault(pair, 0) + 1);
        points.add(pair);
    }
    
    public int count(int[] point) {
        
        int count = 0;
        
        Pair<Integer, Integer> pair1 = new Pair<Integer, Integer>(point[0], point[1]);
        
        for(Pair<Integer, Integer> pair: points){
            
            int xDiff = Math.abs(point[0] - pair.getKey());
            int yDiff = Math.abs(point[1] - pair.getValue());
            
            if(xDiff != yDiff || xDiff == 0 || yDiff == 0) {
                continue;
            }
            
            Pair<Integer, Integer> pair3 = new Pair<Integer, Integer>(pair.getKey(), point[1]);
            Pair<Integer, Integer> pair4 = new Pair<Integer, Integer>(point[0], pair.getValue());
            
            if(coordinateMap.containsKey(pair3) && coordinateMap.containsKey(pair4)){
                
                count += (coordinateMap.get(pair3) * coordinateMap.get(pair4));
            }
        }
        
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */