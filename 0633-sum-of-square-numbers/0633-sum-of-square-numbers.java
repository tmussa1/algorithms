class Solution {
    
    public boolean judgeSquareSum(int c) {
        
        if(c <= 2) return true;
        
        for(long i = 0; i * i <= c; i++){
            
            double product = Math.sqrt(c - (i * i));
            
            if(product == (int) product) return true;
        }
        
        return false;
    }
}