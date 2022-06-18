class Solution {
    
    public boolean isPalindrome(String s) {
        
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            
            char c1 = Character.toLowerCase(s.charAt(i)), c2 = Character.toLowerCase(s.charAt(j));
            
            if((c1 >= 'a' && c1 <= 'z') || Character.isDigit(c1)){
                if( (c2 >= 'a' && c2 <= 'z') || Character.isDigit(c2)){
                    if(c1 == c2) {
                        i++;
                        j--;
                    } else {
                        return false;
                    }
                } else {
                    j--;
                }   
            } else {
                i++;
            }
        }
        
        return true;
    }
}