class Solution {
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int consecutiveZeros = 0, zeroes = 1;
        
        
        for(int flower: flowerbed){
            if(flower == 1){
                zeroes = 0;
            } else {
                zeroes++;
            }
            if(zeroes == 3){
                consecutiveZeros++;
                zeroes = 1;
            }
        }
        
        if(flowerbed[flowerbed.length - 1] == 0 && zeroes > 1){
               consecutiveZeros++;  
        }
        
        return consecutiveZeros >= n;
    }
}