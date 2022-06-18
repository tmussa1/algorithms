class Solution {
    
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.equals(s2)) return true;
        if(s1.length() > s2.length()) return false;
        
        int [] s1Chars = new int[26];
        int [] s2Chars = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            s1Chars[s1.charAt(i) - 'a']++;
            s2Chars[s2.charAt(i) - 'a']++;
        }
        
        int window = s1.length();
        
        for(int i = s1.length(); i < s2.length(); i++){
            
            if(Arrays.equals(s1Chars, s2Chars)) return true;
            
            s2Chars[s2.charAt(i) - 'a']++;
            s2Chars[s2.charAt(i - window) - 'a']--;
        }
        
        if(Arrays.equals(s1Chars, s2Chars)) return true;
        
        return false;
    }
}