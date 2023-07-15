class Solution {
    public int longestPalindrome(String s) {
        
        int result = 0, oddCount = 0;
        
        Map<Character, Integer> counter = new HashMap<>();
        
        char [] sArray = s.toCharArray();
        
        for(char c: sArray){
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        
        for(char c: counter.keySet()){
            if(counter.get(c) % 2 == 0){
                result += counter.get(c);
            } else {
                result += (counter.get(c) - 1);
                oddCount = 1;
            }
        }
        
        return result + oddCount;
    }
}