class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> dict = new HashSet<>(wordDict);
        
        return dfs(s, 0, dict);
    }
    
    private List<String> dfs(String s, int start, Set<String> dict) {
        
        List<String> result = new ArrayList<>();
            
        if(start == s.length()){
            result.add("");
            return result;
        }
        
        for(int i = start + 1; i <= s.length(); i++){
            
            String word = s.substring(start, i);
            
            if(dict.contains(word)){
                List<String> subSolution = dfs(s, i, dict);
                
                for(String str: subSolution){
                    if(str.equals("")){
                        result.add(new String(word));
                    } else {
                        result.add(new String(word + " " + str));
                    }
                }
            }
        }
        
        return result;
    }
}