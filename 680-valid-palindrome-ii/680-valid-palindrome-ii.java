class Solution {
    
    public boolean validPalindrome(String s) {
        
        int left = 0, right = s.length() - 1;
        
        char [] cArr = s.toCharArray();
        
        while(left < right){
            
            if(cArr[left] == cArr[right]){
                left++;
                right--;
            } else {
               return checkPalindrome(s, left + 1, right) || checkPalindrome(s, left, right - 1);
            }
        }
        
        
        return true;
    }
    
    private boolean checkPalindrome(String s, int left, int right){
        
        while(left < right){
            
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    
}