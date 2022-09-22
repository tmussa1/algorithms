class Solution {
    
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character, Integer> indexMap = new HashMap<>();
        
        for(int i = 0; i < order.length(); i++){
            char orderChar = order.charAt(i);
            indexMap.put(orderChar, i);
        }
        
        for(int i = 1; i < words.length; i++){
            
            String word1 = words[i - 1], word2 = words[i];
            int j = 0;
            
            inner:
            for(j = 0; j < Math.min(word1.length(), word2.length()); j++){
                
                int index1 = indexMap.get(word1.charAt(j)), index2 = indexMap.get(word2.charAt(j));
                
                if(index1 < index2){
                    break inner;
                } else if(index1 == index2){
                    continue;
                } else {
                    return false;
                }
            }
            
            if(j == word2.length() && j < word1.length()){
                return false;
            }
        }
        
        return true;
    }
}