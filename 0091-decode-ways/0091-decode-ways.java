class Solution {
    
    public int numDecodings(String s) {
        return canDecod(new HashMap<>(), s, 0);
    }
    
    
    private int canDecod(Map<Integer, Integer> memo, String s, int index){
        
        
        if(index == s.length()) return 1;
        
        if(memo.containsKey(index)) return memo.get(index);
            
        int ways = 0;
        
        if(index + 1 <= s.length() && isDecodable(s.substring(index, index + 1))){
            ways += canDecod(memo, s, index + 1);
        } 
        
        if(index + 2 <= s.length() && isDecodable(s.substring(index, index + 2))){
            ways += canDecod(memo, s, index + 2);
        } 
        
        memo.put(index, ways);
        
        return memo.get(index);
    }
    
    
    private boolean isDecodable(String letter){
        return letter.length() <= 2 && letter.charAt(0) != '0'
            && Integer.parseInt(letter) <= 26
            && Integer.parseInt(letter) >= 1;
    }
}