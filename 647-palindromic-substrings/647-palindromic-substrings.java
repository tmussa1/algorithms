class Solution {
    
    public int countSubstrings(String s) {
        
        int index = 0, count = 0;
        
        while(index < s.length()){
            count += countPalindrome(s, index, index);
            count += countPalindrome(s, index, index + 1);
            index++;
        }
        
        return count;
    }
    
    private int countPalindrome(String s, int left, int right){
        
        int count = 0;
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        
        return count;
    }
}