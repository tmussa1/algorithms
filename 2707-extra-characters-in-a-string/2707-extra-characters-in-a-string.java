class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        
        Set<String> dictSet = new HashSet<>();
        Collections.addAll(dictSet, dictionary);
        
        Integer [] memo = new Integer[s.length()];
        
        return minExtraChar(s, dictSet, 0, memo);
    }
    
    int minExtraChar(String s, Set<String> dictSet,
                     int index, Integer [] memo) {
        
        if(index >= s.length()){
            return 0;
        }
        
        if(memo[index] != null) return memo[index];
        
        int result = 1 + minExtraChar(s, dictSet, index + 1, memo);
        
        for(int i = index; i <= s.length(); i++){
            if(dictSet.contains(s.substring(index, i))){
               result = Math.min(result, minExtraChar(s, dictSet, i, memo));
            } 
            memo[index] = result;
        }
        
        return memo[index];
    }
}