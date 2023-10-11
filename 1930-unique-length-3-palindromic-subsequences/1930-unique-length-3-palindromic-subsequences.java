class Solution {
    
    public int countPalindromicSubsequence(String s) {
        
        Set<String> result = new HashSet<>();
        
        Map<Character, Integer> countMap = new HashMap<>();
        
        for(char c: s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        Set<Character> leftChars = new HashSet<>();
        
        int index = 0;
        
        while(index < s.length()){
            
            char curr = s.charAt(index);
            
            countMap.put(curr, countMap.get(curr) - 1);
            
            if(countMap.get(curr) == 0){
                countMap.remove(curr);
            }
            
            for(char c: leftChars){
                if(countMap.containsKey(c)){
                    String key = c + "," + curr + "," + c;
                    result.add(key);
                }
            }
            
            leftChars.add(curr);
            
            index++;
        }
        
        
        return result.size();
    }
}