import java.math.*;

class Solution {
    
    public long interchangeableRectangles(int[][] rectangles) {
        
        Map<Double, Long> interMap = new HashMap<>();
        
        for(int [] rect: rectangles){
            double ratio = rect[0] * 1.0 / rect[1];
            interMap.put(ratio, interMap.getOrDefault(ratio, 0L) + 1L);
        }
        
        long sum = 0;
        
        for(Double key: interMap.keySet()){
            long size = interMap.get(key);
            sum += (size * (size - 1)) / 2;
        }
        
        return sum;
    }
}