class Solution {
    
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder builder = new StringBuilder();
        
        int index1 = 0, index2 = 0, resultIndex = 0;
        
        while(index1 < word1.length() && index2 < word2.length()){
            
            if(resultIndex % 2 == 0){
                builder.append(word1.charAt(index1++));
            } else {
                builder.append(word2.charAt(index2++));
            }
            
            resultIndex++;
        }
        
        while(index1 < word1.length()) {
           builder.append(word1.charAt(index1++));
        }
        
        while(index2 < word2.length()) {
          builder.append(word2.charAt(index2++));
        }
        
        return builder.toString();
    }
}