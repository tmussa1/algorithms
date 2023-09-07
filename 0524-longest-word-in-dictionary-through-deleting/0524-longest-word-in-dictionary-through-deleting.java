class Solution {
    
    public String findLongestWord(String s, List<String> dictionary) {
        
         String result = "";
        
        for(String word: dictionary){
            
            if(word.length() < result.length()){
                continue;
            }
            
            int wordIndex = 0, sIndex = 0, matches = 0;
            
            while(wordIndex < word.length() && sIndex < s.length()){
                
                if(s.charAt(sIndex) == word.charAt(wordIndex)){
                    matches++;
                    wordIndex++;
                }
                
                sIndex++;
            }
            
            if(wordIndex == word.length()){
                if(word.length() > result.length()){
                    result = word;
                } else if(word.length() == result.length() && result.compareTo(word) > 0){
                    result = word;
                }
            }
        }
        
        return result;
    }
}