class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        char [] sArray = s.toCharArray();
        char [] tArray = t.toCharArray();
        
        for(char c: sArray){
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        
        for(char c: tArray){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
    
        return sMap.equals(tMap);
    }
}