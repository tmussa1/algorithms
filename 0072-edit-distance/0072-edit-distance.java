class Solution {
    
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0, new Integer[word1.length()][word2.length()]);
    }
    
    private int minDistance(String word1, String word2,
                           int index1, int index2,
                           Integer [] [] memo) {
        
        if(index1 == word1.length()){
            return word2.length() - index2;
        }
        
        if(index2 == word2.length()){
            return word1.length() - index1;
        }
        
        if(memo[index1][index2] != null) return  memo[index1][index2];
        
        if(word1.charAt(index1) == word2.charAt(index2)){
            return minDistance(word1, word2, index1 + 1, index2 + 1, memo);
        }
        
        int add = 1 + minDistance(word1, word2, index1, index2 + 1, memo);
        int remove = 1 + minDistance(word1, word2, index1 + 1, index2, memo);
        int replace = 1 + minDistance(word1, word2, index1 + 1, index2 + 1, memo);
        
        memo[index1][index2] = Math.min(replace, Math.min(add, remove));
        
        return memo[index1][index2];
    }
}