class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        Map<Character, Integer> patternMap = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++){
            char currChar = p.charAt(i);
            patternMap.put(currChar, patternMap.getOrDefault(currChar, 0) + 1);
        }
        
        int windowStart = 0, matches = 0;
        
        List<Integer> resultIndices = new ArrayList<>();
        
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            
            char currChar = s.charAt(windowEnd);
            
            if(patternMap.containsKey(currChar)) {
                
                patternMap.put(currChar, patternMap.getOrDefault(currChar, 0) - 1);
                
                if(patternMap.get(currChar) == 0){
                    matches++;
                }
            }
            
            if(matches == patternMap.size()){
                resultIndices.add(windowStart);
            }
            
            if(windowEnd >= p.length() - 1){ 
                char leftChar = s.charAt(windowStart);
                if(patternMap.containsKey(leftChar)){
                    if(patternMap.get(leftChar) == 0) matches--;
                    patternMap.put(leftChar, patternMap.getOrDefault(leftChar, 0) + 1);
                }
                windowStart++;
            }
        }
        
        return resultIndices;
    }
}