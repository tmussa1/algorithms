class Solution {
    
    public int minimizedMaximum(int n, int[] quantities) {
        
       Arrays.sort(quantities);
        
       int left = 1, right = Arrays.stream(quantities).max().getAsInt(), result = Integer.MAX_VALUE;
        
       while(left <= right){
           
           int mid = left + ((right - left) / 2);
           
           if(canPlace(n, quantities, mid)){
               result = Math.min(mid, result);
               right = mid - 1;
           } else {
               left = mid + 1;
           }
       }
        
       return result;
    }
    
    private boolean canPlace(int n, int [] quantities, int maxQuant){
        
        int index = 0, remaining = quantities[0], quant = 0;
        
        int [] result = new int [n];
        
        int resIndex = 0;
        
        while(index < quantities.length){
            
            while(resIndex < n && remaining > 0){
                result[resIndex++] = Math.min(maxQuant, remaining);
                quant += Math.min(maxQuant, remaining);
                remaining -= maxQuant;
            }

            index++;
            
            if (index < quantities.length) remaining = quantities[index];
        }
        
        return quant == Arrays.stream(quantities).sum() && resIndex <= n;
    }
}