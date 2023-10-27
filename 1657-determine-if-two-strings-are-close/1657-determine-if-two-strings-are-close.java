class Solution {
    
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length() != word2.length()) {
            return false;
        }
        
        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();
        
        for(int i = 0; i < word1.length(); i++){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            word1Map.put(c1, word1Map.getOrDefault(c1, 0) + 1);
            word2Map.put(c2, word2Map.getOrDefault(c2, 0) + 1);
        }
        
        if(!word1Map.keySet().equals(word2Map.keySet())) return false;
        
        List<Integer> freq1 = new ArrayList<>(word1Map.values());
        List<Integer> freq2 = new ArrayList<>(word2Map.values());
        
        Collections.sort(freq1);
        Collections.sort(freq2);
        
        return freq1.equals(freq2);
    }
}