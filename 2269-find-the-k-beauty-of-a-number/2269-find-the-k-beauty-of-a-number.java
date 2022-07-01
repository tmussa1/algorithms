class Solution {
    
    public int divisorSubstrings(int num, int k) {
        
        String digits = String.valueOf(num);
        
        int index = 0, result = 0;
        
        while(index + k <= digits.length()){
            
            String subStr = digits.substring(index, index + k);
            
            int skipZeroIndex = 0;
            
            while(skipZeroIndex < subStr.length() && subStr.charAt(skipZeroIndex) == '0'){
                skipZeroIndex++;
            }
            
            int remainder = skipZeroIndex < subStr.length() && !subStr.substring(skipZeroIndex).equals("") ? num % Integer.parseInt(subStr.substring(skipZeroIndex)): -1;
            
            if(remainder == 0){
                result++;
            }
            
            index++;
        }
        
        return result;
    }
}