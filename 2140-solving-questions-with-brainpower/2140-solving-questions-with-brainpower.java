class Solution {
    public long mostPoints(int[][] questions) {
        return mostPoints(questions, 0, new Long [questions.length]);
    }
    
    private long mostPoints(int[][] questions, int index, Long [] memo) {
        
        if(index >= questions.length){
            return 0;
        }
        
        if(memo[index] != null) return memo[index];
        
        long solve = questions[index][0] + mostPoints(questions, index + questions[index][1] + 1, memo);
        long skip = mostPoints(questions, index + 1, memo);
        
        memo[index] = Math.max(skip, solve);
        
        return memo[index];
    }
}