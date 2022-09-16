class Solution {
    
    public int minimumRecolors(String blocks, int k) {
        
        int result = Integer.MAX_VALUE, bCount = 0, windowStart = 0;
        
        for(int windowEnd = 0; windowEnd < blocks.length(); windowEnd++){
            
            char currChar = blocks.charAt(windowEnd);
            
            if(currChar == 'B'){
                bCount++;
            }
            
            if(windowEnd >= k - 1){
                
                result = Math.min(result, k - bCount);
                
                if(blocks.charAt(windowStart) == 'B'){
                    bCount--;
                }
                
                windowStart++;
            }
        }
        
        return result;
    }
}