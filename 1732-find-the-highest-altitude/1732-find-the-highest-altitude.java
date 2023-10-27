class Solution {
    
    public int largestAltitude(int[] gain) {
        
        int prefixSum = 0, result = 0;
        
        for(int g: gain){
            prefixSum += g;
            result = Math.max(result, prefixSum);
        }
        
        return result;
    }
}