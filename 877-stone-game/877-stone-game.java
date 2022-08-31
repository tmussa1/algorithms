class Solution {
    
    public boolean stoneGame(int[] piles) {
        
        int sum = Arrays.stream(piles).sum();
        
        return stoneGame(piles, 0, piles.length - 1, 0, sum / 2, new Boolean[piles.length][piles.length]);
    }
    
    private boolean stoneGame(int[] piles, int left, int right, int currentSum,
                              int targetSum, Boolean [] [] memo){
        
        if(memo[left][right] != null){
            return memo[left][right];
        }
            
        if(left >= right){
            return false;
        }
        
        if(currentSum >= targetSum){
            return true;
        }
        
        if(stoneGame(piles, left + 1, right, currentSum + piles[left], targetSum, memo)
           || stoneGame(piles, left, right - 1, currentSum + piles[right], targetSum, memo)) {
            memo[left][right] = true;
            return true;
        }
        
        memo[left][right] = false;
        
        return memo[left][right];
    }
}