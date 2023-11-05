class Solution {
    
    public boolean wordPatternMatch(String pattern, String s) {
        
        if(pattern.length() > s.length()) return false;
        
        return wordMatch(pattern, s, 0, 0, new HashMap<>(), new HashSet<>());
    }
    
    private boolean wordMatch(String pattern, String s, int pIndex, int sIndex,
                              Map<Character, String> cache, Set<String> visited){
        
        if(pIndex == pattern.length() && sIndex == s.length()){
            return true;
        }
        
        if(pIndex == pattern.length() || sIndex == s.length()){
            return false;
        }
        
        char c = pattern.charAt(pIndex);
        
        if(cache.containsKey(c)){
            
            String stored = cache.get(c);
            
            if(!s.startsWith(stored, sIndex)){
                return false;
            }
            
            return wordMatch(pattern, s, pIndex + 1, sIndex + stored.length(), cache, visited);
        } else {
            
            for(int i = sIndex; i < s.length(); i++){
                
                String sub = s.substring(sIndex, i + 1);
                
                if(visited.contains(sub)){
                    continue;
                }
                
                cache.put(c, sub);
                visited.add(sub);
                
                if(wordMatch(pattern, s, pIndex + 1, i + 1, cache, visited)){
                    return true;
                }
                
                cache.remove(c);
                visited.remove(sub);
            }
        }
        
        return false;
    }
}