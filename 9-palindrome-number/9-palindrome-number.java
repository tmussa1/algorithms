class Solution {
    public boolean isPalindrome(int x) {
        
        String digits = String.valueOf(x);
        
        int left = 0, right = digits.length() - 1;
        
        while(left < right){
            if(digits.charAt(left) != digits.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}