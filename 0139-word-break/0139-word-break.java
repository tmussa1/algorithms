class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
       Set<String> words = new HashSet<>(wordDict);
        
       Boolean [] memo = new Boolean[s.length()];
        
       boolean result = wordBreak(s, 0, words, memo);
        
       return result;
    }
    
    private boolean wordBreak(String s, int index,
                             Set<String> wordDict,
                             Boolean [] memo){
        
        if(index == s.length()){
            return true;
        }
        
        if(memo[index] != null) return memo[index];
        
        for(int i = index; i <= s.length(); i++){
            if(wordDict.contains(s.substring(index, i)) && wordBreak(s, i, wordDict, memo)){
                memo[index] = true;
                return true;
            }
        }
        
        memo[index] = false;
        
        return memo[index];
    }
}