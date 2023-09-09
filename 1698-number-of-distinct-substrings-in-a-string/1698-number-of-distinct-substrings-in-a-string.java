class Solution {
    
    public int countDistinct(String s) {
        
        Set<String> suffixes = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){;
            suffixes.add(s.substring(i));
            for(int j = 0; j < i; j++){
                suffixes.add(s.substring(j, i));
               // suffixes.add(s.substring(j));
            }  
        }
        
        return suffixes.size();
    }
}