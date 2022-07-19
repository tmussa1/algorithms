class Solution {
    
    public int titleToNumber(String columnTitle) {
        
        int result = 0;
        
        char [] columnArray = columnTitle.toCharArray();
        
        for(int i = 0; i < columnArray.length; i++){
            char column = columnArray[i];
            result += (Math.pow(26, columnArray.length - i - 1) * ((column - 'A') + 1));
        }
        
        return result;
    }
}