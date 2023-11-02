class Solution {
    
    
    public int[] pourWater(int[] heights, int volume, int k) {
        
        for(int i = 1; i <= volume; i++){
            
            int leftIndex = findLeftIndex(heights, k);
            
            if(leftIndex < k){
                heights[leftIndex]++;
            } else {
                int rightIndex = findRightIndex(heights, k);
                
                if(rightIndex > k){
                    heights[rightIndex]++;
                } else {
                    heights[k]++;
                }
            }
        }
        
        return heights;
    }
    
    private int findLeftIndex(int[] heights, int k){
        
        int height = heights[k];
        int result = k;
        
        for(int i = k; i >= 0; i--){
            
            if(heights[i] > height){
                break;
            }
            
            if(heights[i] < height){
                height = heights[i];
                result = i;
            } 
        }
        
        return result;
    }
    
    private int findRightIndex(int[] heights, int k){
        
        int height = heights[k];
        int result = k;
        
        for(int i = k; i < heights.length; i++){
            
            if(heights[i] > height){
                break;
            }
            
            if(heights[i] < height){
                height = heights[i];
                result = i;
            } 
        }
        
        return result;
    }
}