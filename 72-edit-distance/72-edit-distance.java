class Solution {
    
    public int minDistance(String word1, String word2) {
        
      int [] [] memo = new int[word1.length() + 1][word2.length() + 1];
        
      for(int i = 0; i < memo.length; i++){
          Arrays.fill(memo[i], - 1);
      }
        
      return minDistance(0, 0, word1, word2, memo);
    }
    
    public int minDistance(int i, int j, String word1, String word2, int[][] memo) {
        
        if(i == word1.length() && j == word2.length()){
            return 0;
        }
        
        if(i == word1.length()){
            return (word2.length() - j);
        }
        
        if(j == word2.length()){
            return (word1.length() - i);
        }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        if(word1.equals(word2)){
            return 0;
        }
        
        char c1 = word1.charAt(i), c2 = word2.charAt(j);
        
        if(c1 == c2){
            return minDistance(i + 1, j + 1, word1, word2, memo);
        }
        
        memo[i][j] = Math.min(1 + minDistance(i + 1, j, word1, word2, memo),
                        Math.min(1 + minDistance(i, j + 1, word1, word2, memo),
                        1 + minDistance(i + 1, j + 1, word1, word2, memo)));
        
        return memo[i][j];
    }
}