class Solution {
    
    public int partitionString(String s) {
        
        int [] charCount = new int[26];
        
        int left = 0, right = 0, result = 1;
        
        while(right < s.length()){
            
            char c = s.charAt(right);
            
            if(charCount[c - 'a'] > 0){
                while(left < right){
                    charCount[s.charAt(left) - 'a']--;
                    left++;
                }
                result++;
            }
            
            charCount[c - 'a']++;
            
            right++;
        }
        
        return result;
    }
}