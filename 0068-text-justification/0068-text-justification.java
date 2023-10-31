class Solution {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        int i = 0, j = 0, n = words.length;
        List<String> result = new ArrayList<>();
        
        while(j < n){
            
            int lineLength = words[i].length();
            j = i + 1;
            
            while(j < n && (lineLength + words[j].length() + (j - i - 1) < maxWidth)){
                 lineLength += words[j].length();
                 ++j;
            }
            
            if((j - i) == 1 || j >= n){
                result.add(leftJustify(words, i, j, lineLength, maxWidth));
            } else {
                result.add(middleJustify(words, i, j, lineLength, maxWidth));
            }
            
            i = j;
        }
        
        return result;
    }
    
    private String leftJustify(String [] words, int i, int j, int lineLength, int maxWidth){
        StringBuilder result = new StringBuilder(words[i]);
        int numSpaces = (maxWidth - lineLength) - (j - i - 1);
        
        for(int k = i + 1; k < j; k++){
          result.append(" " + words[k]);
        }
        
        result.append(" ".repeat(numSpaces));
        
        return result.toString();
    }
    
    private String middleJustify(String [] words, int i, int j, int lineLength, int maxWidth){
        StringBuilder result = new StringBuilder(words[i]);
        int numSpaces = (maxWidth - lineLength) / (j - i - 1);  
        int extraSpaces = (maxWidth - lineLength) % (j - i - 1);
        
        for(int k = i + 1; k < j; k++){
          result.append(" ".repeat(numSpaces + (extraSpaces-- > 0 ? 1 : 0)) + words[k]);
        }
        
        return result.toString();        
    }
}