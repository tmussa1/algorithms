class Solution {
    
    public List<List<Integer>> palindromePairs(String[] words) {
        
        Set<List<Integer>> result = new HashSet<>();
        
        Map<String, Integer> cache = new HashMap<>();
        
        for(int index = 0; index < words.length; index++){
            String word = words[index];
            cache.put(word, index);
        }
        
        for(int index = 0; index < words.length; index++){
            
            String word = words[index];
            
            if(word.equals("")){
                for(int i = 0; i < words.length; i++){
                    if(i != index && isPalindrome(words[i], 0, words[i].length() - 1)){
                        result.add(Arrays.asList(index, i));
                        result.add(Arrays.asList(i, index));
                    }
                }
                continue;
            }
            
            String reversed2 = new StringBuilder(word).reverse().toString();
            
            if(cache.containsKey(reversed2) && cache.get(reversed2) != index){
                result.add(Arrays.asList(index, cache.get(reversed2)));
            }
            
            for(int j = 1; j < word.length(); j++){
                    
                String sub = word.substring(0, j), sub1 = word.substring(j);

                String reversed = new StringBuilder(sub).reverse().toString();
                String reversed1 = new StringBuilder(sub1).reverse().toString();

                if(isPalindrome(word, 0, j - 1) && cache.getOrDefault(reversed1, -1) != index && cache.containsKey(reversed1)){
                    result.add(Arrays.asList(cache.get(reversed1), index));
                }
                
                if(isPalindrome(word, j, word.length() - 1) && cache.getOrDefault(reversed, -1) != index && cache.containsKey(reversed)){
                    result.add(Arrays.asList(index, cache.get(reversed)));
                }
            }
        }
        
        return new ArrayList<>(result);
    }
    
    private boolean isPalindrome(String s, int left, int right){
        
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        
        return true;
    }
}