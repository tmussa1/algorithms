class Solution {
    
    public int countLetters(String s) {
        
        Map<Character, Integer> countMap = new HashMap<>();
        
        int windowStart = 0, windowEnd = 0, result = 0;
        
        while(windowEnd < s.length()){
            
            char currChar = s.charAt(windowEnd);
            
            countMap.put(currChar, countMap.getOrDefault(currChar, 0) + 1);
            
            while(countMap.size() > 1){
                
               char firstChar = s.charAt(windowStart);
               countMap.put(firstChar, countMap.get(firstChar) - 1);
            
               if(countMap.get(firstChar) == 0){
                   countMap.remove(firstChar);
               }
                
               windowStart++;
            }
            
            windowEnd++;
            result += countMap.get(currChar);
        }
        
        return result;
    }
}