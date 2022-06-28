class Solution {
    
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int wordLength = 0;
            
        int index = 0;
        
        while(index < abbr.length()){
            
            char c = abbr.charAt(index);
            
            if(!Character.isDigit(c) && wordLength < word.length()){
                char w = word.charAt(wordLength);
                if(c != w) return false;
            }
            
            if(Character.isDigit(c)){
                
                if(Integer.parseInt(c + "") == 0){
                    return false;
                }
                
                int firstIndex = index;
                
                while(index < abbr.length() && Character.isDigit(abbr.charAt(index))){
                    index++;
                }
                
                String digits = abbr.substring(firstIndex, index);
                
                wordLength += Integer.parseInt(digits);
                
            } else {
                index++;
                wordLength++;
            }
        }
        
        return wordLength == word.length();
    }
}