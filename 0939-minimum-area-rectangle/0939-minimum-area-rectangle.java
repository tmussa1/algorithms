class Solution {
    
    public int minAreaRect(int[][] points) {
        
        Set<Pair<Integer, Integer>> coordinates = new HashSet<>();
        
        for(int [] point: points){
            Pair<Integer, Integer> pair = new Pair<>(point[0], point[1]);
            coordinates.add(pair);
        }
        
        int result = Integer.MAX_VALUE;
        
        for(Pair<Integer, Integer> pair1: coordinates){
            
            for(Pair<Integer, Integer> pair2: coordinates){
                
                int xDiff = Math.abs(pair1.getKey() - pair2.getKey());
                int yDiff = Math.abs(pair1.getValue() - pair2.getValue());
                
                if(xDiff == 0 || yDiff == 0) {
                    continue;
                }
                
                int newX2 = pair1.getKey() - xDiff;
                int newY2 = pair1.getValue() - yDiff;
                
                Pair<Integer, Integer> pair3 = new Pair<>(newX2, pair1.getValue());
                Pair<Integer, Integer> pair4 = new Pair<>(pair1.getKey(), newY2);
                
                if(coordinates.contains(pair3) && coordinates.contains(pair4)){
                    
                    int bottom = pair4.getKey() - pair2.getKey();
                    int top = pair1.getKey() - pair3.getKey();
                    int right = pair1.getValue() - pair4.getValue();
                    int left = pair3.getValue() - pair2.getValue();
                    
//                     int diagonal1 = ((int) (Math.pow(Math.abs(pair3.getKey() - pair1.getKey()), 2) +
//                         Math.pow(Math.abs(pair3.getValue() - pair1.getValue()), 2)));
                    
//                     int diagonal2 = ((int) (Math.pow(Math.abs(pair4.getKey() - pair2.getKey()), 2) +
//                         Math.pow(Math.abs(pair4.getValue() - pair2.getValue()), 2)));
                    
//                     int diagonal3 = ((int) (Math.pow(Math.abs(pair3.getKey() - pair2.getKey()), 2) +
//                         Math.pow(Math.abs(pair3.getValue() - pair2.getValue()), 2)));
                    
//                     int diagonal4 = ((int) (Math.pow(Math.abs(pair4.getKey() - pair3.getKey()), 2) +
//                         Math.pow(Math.abs(pair4.getValue() - pair3.getValue()), 2)));
                    
//                      System.out.println("Result " + xDiff + " " + yDiff + " diag " + diagonal1);
//                      System.out.println("Pair 1 " + pair1);
//                      System.out.println("Pair 2 " + pair2);
//                      System.out.println("Pair 3 " + pair3);
//                      System.out.println("Pair 4 " + pair4);
                    
                    if(top != bottom || left != right) {
                        continue;
                    }
                    
                    result = Math.min(result, xDiff * yDiff);
                }
            }
        }
        
        return result == Integer.MAX_VALUE ?  0 : result;
    }
}