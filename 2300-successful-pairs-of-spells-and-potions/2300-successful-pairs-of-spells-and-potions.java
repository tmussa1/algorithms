class Solution {
    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        
        int [] result = new int[spells.length];
        
        for(int i = 0; i < spells.length; i++){
            int search = binarySearch(potions, spells[i], success);
            result[i] = (potions.length - search);
        }
        
        return result;
    }
    
    int binarySearch(int [] potions, int spell, long success){
        
        int left = 0, right = potions.length;
        
        while(left < right){
            
            int mid = left + ((right - left) / 2);
            
            long product = (long) potions[mid] * spell;
            
            if(product < success){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}