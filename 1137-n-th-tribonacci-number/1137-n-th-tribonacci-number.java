class Solution {
    public int tribonacci(int n) {
        int [] memo = new int[n + 1];
        return tribonacci(n, memo);
    }
    
    private int tribonacci(int n, int [] memo){
        if(n <= 1){
            return n;
        }
        
        if(n == 2){
            return 1;
        }
        
        if(memo[n] > 0){
            return memo[n];
        }
        
        memo[n] = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) +
                  tribonacci(n - 3, memo);
        
        return memo[n];
    }
}