class Solution {
    
    public int minCost(String colors, int[] neededTime) {
        
        char [] colorsArray = colors.toCharArray();
        int minRemovals = 0, index = 0, max = 0;
        
        while(index < colors.length()){
            
            char currChar = colorsArray[index];
            
            int firstIndex = index;
            
            while(index < colors.length() && currChar == colorsArray[index]){
                max = Math.max(max, neededTime[index]);
                minRemovals += neededTime[index++];
            }
            
            minRemovals -= max;
            
            max = 0;
            
            if(firstIndex == index) index++;
        }
        
        return minRemovals;
    }
}
