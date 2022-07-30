class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int [] [] dp = new int [text1.length()][text2.length()];
        
        char [] text1Arr = text1.toCharArray();
        char [] text2Arr = text2.toCharArray();
        
        dp[0][0] = text1Arr[0] == text2Arr[0] ? 1 : 0;
        
        for(int i = 1; i < text1.length(); i++){
            dp[i][0] = text1Arr[i] == text2Arr[0] ? 1 : dp[i - 1][0];
        }
        
        for(int i = 1; i < text2.length(); i++){
            dp[0][i] = text2Arr[i] == text1Arr[0] ? 1 : dp[0][i - 1];
        }
        
        for(int i = 1; i < text1.length(); i++){
            for(int j = 1; j < text2.length(); j++){
                if(text1Arr[i] == text2Arr[j]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        for(int i = 0; i < text1.length(); i++){
           for(int j = 0; j < text2.length(); j++){
                System.out.print(dp[i][j] + " ");
           }
           System.out.println();
        }
        
        return dp[text1.length() - 1][text2.length() - 1];
    }
}