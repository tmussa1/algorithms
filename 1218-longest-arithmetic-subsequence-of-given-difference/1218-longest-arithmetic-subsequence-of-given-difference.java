class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int [] dp = new int [arr.length];
        
        int max = 1;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            
            dp[i] = 1;
            
            int sum = arr[i] - difference;
            int sumMap = countMap.getOrDefault(sum, 0);
            
            dp[i] = Math.max(dp[i], sumMap + 1);
            
            countMap.put(arr[i], dp[i]);
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}