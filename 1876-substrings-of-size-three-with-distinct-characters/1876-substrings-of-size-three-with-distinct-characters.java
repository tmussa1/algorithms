class Solution {
    
    public int countGoodSubstrings(String s) {
        
        Map<Character, Integer> countMap = new HashMap<>();
        
        int window = 3, windowCount = 0;
        int result = s.length() - 2;
        
        if(s.length() < window) return 0;
        
        for(int i = 0; i < window; i++){
            
            char c = s.charAt(i);
            
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        
        if(containsValue(countMap)){
            result--;
        }
        
        for(int i = window; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if(countMap.containsKey(c) && countMap.get(c) > 0){
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
            
            char leftChar = s.charAt(i - window);
            
            countMap.put(leftChar, countMap.get(leftChar) - 1);
            
            if(containsValue(countMap)){
                result--;
            }
        }
        
        return result;
    }
    
    boolean containsValue(Map<Character, Integer> countMap){
        
        for(Map.Entry<Character, Integer> entry: countMap.entrySet()){
            if(entry.getValue() > 1){
                return true;
            }
        }
        
        return false;
    }
}