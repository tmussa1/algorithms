class Solution {
    
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Character> charMap = new HashMap<>();
        Map<Character, Character> tCharMap = new HashMap<>();
        
        char [] sArr = s.toCharArray(), tArr = t.toCharArray();
        
        for(int i = 0; i < sArr.length; i++){
            
            char cChar = sArr[i], tChar = tArr[i];
            
            if((charMap.containsKey(cChar) && charMap.get(cChar) != tChar)
               || (tCharMap.containsKey(tChar) && tCharMap.get(tChar) != cChar)){
                return false;
            } else {
                charMap.put(cChar, tChar);
                tCharMap.put(tChar, cChar);
            }
        }
        
        return true;
    }
}