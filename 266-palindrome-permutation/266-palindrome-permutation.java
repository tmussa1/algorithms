class Solution {
    
    public boolean canPermutePalindrome(String s) {
        
        Map<Character, Integer> countMap = new HashMap<>();
        int numOdds = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> entry: countMap.entrySet()){
            
            if(entry.getValue() % 2 == 1){
                numOdds++;
            }
        }
        
        return numOdds <= 1;
    }
}