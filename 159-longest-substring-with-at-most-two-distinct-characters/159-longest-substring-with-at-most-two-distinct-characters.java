class Solution {
    
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        Map<Character, Integer> countMap = new HashMap<>();
        
        char [] sArr = s.toCharArray();
        
        int index = 0, windowBegin = 0, result = 0;
        
        while(index < s.length()){
            
            char currChar = sArr[index];
            
            countMap.put(currChar, countMap.getOrDefault(currChar, 0) + 1);
            
            while(countMap.size() > 2){
                
                char beginChar = sArr[windowBegin];
                
                countMap.put(beginChar, countMap.getOrDefault(beginChar, 0) - 1);
                
                if(countMap.get(beginChar) == 0){
                    countMap.remove(beginChar);
                }
                
                windowBegin++;
            }
            
            result = Math.max(result, index - windowBegin + 1);
            
            index++;
        }
        
        return result;
    }
}