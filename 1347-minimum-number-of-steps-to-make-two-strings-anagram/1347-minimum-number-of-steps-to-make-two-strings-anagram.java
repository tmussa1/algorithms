class Solution {
    
    public int minSteps(String s, String t) {
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i), c2 = t.charAt(i);
            sMap.put(c1, sMap.getOrDefault(c1, 0) + 1);
            tMap.put(c2, tMap.getOrDefault(c2, 0) + 1);
        }
        
        int result = 0;
        
        for(Map.Entry<Character, Integer> entry: tMap.entrySet()){
            int tCount = entry.getValue();
            int sCount = sMap.getOrDefault(entry.getKey(), 0);
            
            result += Math.max(0, tCount - sCount);
        }
        
        return result;
    }
}