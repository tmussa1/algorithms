class Solution {
    
    public int bestTeamScore(int[] scores, int[] ages) {
        
        int [] dp = new int[scores.length];
        
        int [] [] scoreAges = new int[scores.length][2];
        
        for(int i = 0; i < scores.length; i++){
            scoreAges[i][0] = scores[i];
            scoreAges[i][1] = ages[i];
        }
        
        Arrays.sort(scoreAges, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        for(int i = 0; i < scores.length; i++){
            
            int score = scoreAges[i][0], age = scoreAges[i][1], j = i - 1;
            
            dp[i] = score;
            
            while(j >= 0){
                if(age >= scoreAges[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + score);
                }
                j--;
            }
        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
}