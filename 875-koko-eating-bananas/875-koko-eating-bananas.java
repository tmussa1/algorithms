class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
        
        if(piles.length == 1) return (int) Math.ceil((double) piles[0] / h);
            
        Arrays.sort(piles);
        
        int min = 1, max = piles[piles.length - 1];
        
        while(min < max){
            
            int k = min + ((max - min) / 2);
                
            int sum = findSum(piles, k);
            
            if(sum <= h){
                max = k;
            } else {
                min = k + 1;
            }
        }
        
        return max;
    }
    
    int findSum(int[] piles, int k){
        
        int sum = 0;
        
        for(int i = 0; i < piles.length; i++) {
            sum += Math.ceil((double) piles[i] / k);
        }
        
        return sum;
    }
}