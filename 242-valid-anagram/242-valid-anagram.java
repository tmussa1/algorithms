class Solution {
    
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char c1 = s.charAt(i), c2 = t.charAt(i);
            
            sMap.put(c1, sMap.getOrDefault(c1, 0) + 1);
            tMap.put(c2, tMap.getOrDefault(c2, 0) + 1);
        }
        
        for(Map.Entry<Character,Integer> entry: sMap.entrySet()){
            
            Character key = entry.getKey();
            Integer value = entry.getValue();
            
            if(!tMap.getOrDefault(key, 0).equals(entry.getValue())){
                return false;
            }
        }
        
        return true;
    }
}