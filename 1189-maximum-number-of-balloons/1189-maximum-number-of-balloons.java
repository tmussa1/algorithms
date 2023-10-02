class Solution {
    
    public int maxNumberOfBalloons(String text) {
        
        int [] ballon = new int[26];
        
        int [] chars = new int[26];
        
        char [] bal = "balloon".toCharArray();
        
        for(char c: bal){
            ballon[c - 'a']++;
        }
        
        char [] textArr = text.toCharArray();
        
        int result = Integer.MAX_VALUE;
        
        for(char c: textArr){
            chars[c - 'a']++;
        }
        
        for(char c: bal){
            if(ballon[c - 'a'] > 0){
               result = Math.min(result, chars[c - 'a'] / ballon[c - 'a']);
            }
        }
        
         return result;
    }
}