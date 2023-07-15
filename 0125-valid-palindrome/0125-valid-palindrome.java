class Solution {
    
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        
        int left = 0, right = s.length() - 1;
        
        while(left <= right){
            char c1 = s.charAt(left), c2 = s.charAt(right);
            
            if((c1 - 'a' >= 26 || c1 - 'a' < 0) && !Character.isDigit(c1)){
                left++;
                continue;
            }
            if((c2 - 'a' >= 26 || c2 - 'a' < 0) && !Character.isDigit(c2)){
                right--;
                continue;
            }
            
            if(c1 != c2){
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}