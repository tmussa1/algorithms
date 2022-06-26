class Solution {
    
    public String convert(String s, int numRows) {

        if(s == null || s.length() <= 1 || s.length() <= numRows || numRows == 1) return s;
            
        int between = numRows + (numRows - 2);
        
        int length = s.length();
        
        int index = 0;
        
        int currentBetween = between;
        
        StringBuilder builder = new StringBuilder();
        
        while(index < length && currentBetween >= 0){
            
            int i = index;
            
            while(i < length){
                
                builder.append(s.charAt(i));
                
                if(index != 0 && i + currentBetween < length && currentBetween > 0){
                    builder.append(s.charAt(i + currentBetween));
                }
                
                i += between;
            }
            
            currentBetween -= 2;
            index++;
        }
        
        return builder.toString();
    }
}