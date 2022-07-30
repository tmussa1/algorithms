class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) 
    {
        Boolean [] memo = new Boolean [s.length()];
        Set<String> seenWords = new HashSet<>();
        seenWords.addAll(wordDict);
        return wordBreakHelper(s, seenWords, memo, 0);
    }

    private static boolean wordBreakHelper(String s, Set<String> wordDict, Boolean [] memo, int index){
      
       if(index == s.length()){
         return true;
       }
      
       if(memo[index] != null){
         return memo[index];
       }

       for(int i = index + 1; i <= s.length(); i++){
         if(wordDict.contains(s.substring(index, i)) && wordBreakHelper(s, wordDict, memo, i)){
           memo[index] = true;
           return true;
         }
       }
        
       memo[index] = false;

       return memo[index];
    }
}