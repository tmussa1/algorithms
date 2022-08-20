class Solution {
    
    static Map<Character, Character> strobogrammaticMap = new HashMap<>() {
        {
            put('0', '0');
            put('1', '1');
            put('6', '9');
            put('8', '8');
            put('9', '6');
        }
    };
        
    public boolean isStrobogrammatic(String num) {
        
        int left = 0, right = num.length() - 1;
        
        while(left <= right){
            
            char leftChar = num.charAt(left), rightChar = num.charAt(right);
            
            if(!strobogrammaticMap.containsKey(leftChar) 
            || !strobogrammaticMap.containsKey(rightChar)
            || leftChar != strobogrammaticMap.get(rightChar)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}