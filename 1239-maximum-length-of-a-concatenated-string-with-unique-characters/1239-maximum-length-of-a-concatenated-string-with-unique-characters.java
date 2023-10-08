class Solution {
    
    public int maxLength(List<String> arr) {
        return maxLength(arr, 0, new HashSet<>());
    }
    
    public int maxLength(List<String> arr, int index, Set<Character> charSet) {
        
        if(index == arr.size()){
            return 0;
        }
        
        int result = 0;
        
        for(int i = index; i < arr.size(); i++){
            
            char [] word = arr.get(i).toCharArray();
            
            if(isUnique(charSet, word)){
                
                for(char c: word){
                    charSet.add(c);
                }
                
                result = Math.max(result, charSet.size());
                
                result = Math.max(result, maxLength(arr, i + 1, charSet));
                    
                for(char c: word){
                    charSet.remove(c);
                }
            }
        }
        
        return result;
    }
    
    private boolean isUnique(Set<Character> charSet, char [] word){
        
        Set<Character> seen = new HashSet<>();
        
        for(char c: word){
            if(charSet.contains(c) || seen.contains(c)){
                return false;
            }
            seen.add(c);
        }
        
        return true;
    }
}