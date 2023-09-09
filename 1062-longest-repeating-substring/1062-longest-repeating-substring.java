class Solution {
    
    public int longestRepeatingSubstring(String s) {
        
        String longest = "";
        
        String [] suffix = new String[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            suffix[i] = s.substring(i);
        }
        
        Arrays.sort(suffix);
        
        int index = 1;
        
        while(index < s.length()){
            
            String word1 = suffix[index - 1], word2 = suffix[index];
            
            String common = commonSuffix(word1, word2);
            
            if(common.length() > longest.length()){
                longest = common;
            }
            
            index++;
        }
        
        return longest.length();
    }
    
    private String commonSuffix(String word1, String word2){
        
        int minLength = Math.min(word1.length(), word2.length());
        
        for(int i = 0; i < minLength; i++){
            if(word1.charAt(i) != word2.charAt(i)){
                return word1.substring(0, i);
            }
        }
        
        return word1.substring(0, minLength);
    }
}