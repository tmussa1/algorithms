class Solution {
    
    public int minDistance(String word1, String word2) {
        Integer [] [] memo = new Integer[word1.length()][word2.length()];
        return minDistance(word1, word2, 0, 0, memo);
    }
    
    private int minDistance(String word1, String word2, 
                            int index1, int index2, Integer [] [] memo){
            
        if(word1.length() == index1 && word2.length() == index2){
            return 0;
        }
        
        if(word1.length() == index1){
            return word2.length() - index2;
        }
        
        if(word2.length() == index2){
            return word1.length() - index1;
        }
        
        if(memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        
        if(word1.charAt(index1) == word2.charAt(index2)){
            return minDistance(word1, word2, index1 + 1, index2 + 1, memo);
        }
        
        int min = Math.min(1 + minDistance(word1, word2, index1 + 1, index2, memo),
                           1 + minDistance(word1, word2, index1, index2 + 1, memo));
        
        memo[index1][index2] = min;
        
        return min;
    }
}