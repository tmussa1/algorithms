class Solution {
    
    public int longestPalindromeSubseq(String s) {
        
        int length = s.length();
        
        int [] [] cache = new int[length + 1][length + 1];
        
        StringBuilder builder = new StringBuilder(s);
        
        String t = builder.reverse().toString();
        
        String sChars = " " + s;
        String tChars = " " + t;
        
        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= length; j++){
                if(sChars.charAt(i) == tChars.charAt(j)){
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }
        
        return cache[length][length];
    }
}