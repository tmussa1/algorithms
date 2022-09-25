class Solution {
    public int numberOfSubstrings(String s) {
        
        int windowStart = 0, windowEnd = 0, substrings = 0;
        
        Map<Character, Integer> countMap = new HashMap<>();
        
        while(windowEnd < s.length()){
            
            char currChar = s.charAt(windowEnd);
            countMap.put(currChar, countMap.getOrDefault(currChar, 0) + 1);
            
            while(countMap.size() == 3){
                
                char leftChar = s.charAt(windowStart);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                
                if(countMap.get(leftChar) == 0){
                    countMap.remove(leftChar);
                }
                
                windowStart++;
            }
            
            substrings += windowStart;
            
            windowEnd++;
        }
        
        return substrings;
    }
}