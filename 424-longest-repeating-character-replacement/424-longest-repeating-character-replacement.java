class Solution {
    
    public int characterReplacement(String s, int k) {
        
        int window_start = 0, result = Integer.MIN_VALUE;
        
        Map<Character, Integer> countMap = new HashMap<>();
            
        for(int index = 0; index < s.length(); index++){
            
            char c = s.charAt(index);
            
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            
            List<Integer> values = new ArrayList<>(countMap.values());
            
            Integer max = values.stream().mapToInt(a -> a).max().orElse(0);
            
            while((index - window_start) + 1 - max > k){
                
                char leftChar = s.charAt(window_start);
                
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                
                values = values = new ArrayList<>(countMap.values());
            
                max = values.stream().mapToInt(a -> a).max().orElse(0);
                    
                window_start++;
            }
            
            
            result = Math.max(result, (index - window_start) + 1);
        }
        
        return result;
    }
}