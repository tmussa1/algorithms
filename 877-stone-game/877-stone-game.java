class Solution {
    
    public boolean stoneGame(int[] piles) {
        
        int sum = Arrays.stream(piles).sum();
        
        return stoneGame(piles, 0, piles.length - 1, 0, sum / 2);
    }
    
    private boolean stoneGame(int[] piles, int left, int right, int currentSum,
                              int targetSum){
        
        if(left >= right){
            return false;
        }
        
        if(currentSum >= targetSum){
            return true;
        }
        
        if(stoneGame(piles, left + 1, right, currentSum + piles[left], targetSum)
           || stoneGame(piles, left, right - 1, currentSum + piles[right], targetSum)) {
            return true;
        }
        
        return false;
    }
}