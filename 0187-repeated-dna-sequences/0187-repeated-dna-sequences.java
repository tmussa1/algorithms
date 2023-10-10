class Solution {
    
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();
        
        if(s.length() < 10) return new ArrayList<>(result);
        
        StringBuilder builder = new StringBuilder();
        
            
        for(int i = 0; i < 10; i++) {
            builder.append(s.charAt(i));
        }
        
        String sub = builder.toString();
        
        if(s.lastIndexOf(sub) != 0){
            result.add(sub);
        }
        
        seen.add(sub);
        
        for(int i = 10; i < s.length(); i++) {
            
            builder.deleteCharAt(0);
            builder.append(s.charAt(i));
            
            String sub2 = builder.toString();
            
            if(seen.contains(sub2)){
                result.add(sub2);
            }
            
            seen.add(sub2);
        }
        
        return new ArrayList<>(result);
    }
}