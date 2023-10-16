class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        return numMusicPlaylists(n, goal, k, 0, 0, new Integer [n + 1] [goal + 1]);
    }
    
    public int numMusicPlaylists(int n, int goal, int k, int currentGoal,
                                 int numSongsPlayed, Integer [] [] memo) {
        
        long mod = 1_000_000_007;
        
        if(currentGoal == goal){
            return numSongsPlayed == n ? 1 : 0;
        }
        
        if(numSongsPlayed > n) {
            return 0;
        }
        
        if(memo[numSongsPlayed][currentGoal] != null){
            return memo[numSongsPlayed][currentGoal];
        }
        
        long diff = (n - numSongsPlayed) % mod;
        
        long result = (diff * numMusicPlaylists(n, goal, k, currentGoal + 1,
                                                              numSongsPlayed + 1, memo)) % mod;
        
        if(numSongsPlayed > k){
            long diff2 = (numSongsPlayed - k) % mod;
            long count = (diff2 * numMusicPlaylists(n, goal, k, currentGoal + 1,
                                                              numSongsPlayed, memo)) % mod;
            result %= mod;
            result += count;
            result %= mod;
        }
        
        memo[numSongsPlayed][currentGoal] = ((int) (result % mod));
        
        return (int) result;
    }
}