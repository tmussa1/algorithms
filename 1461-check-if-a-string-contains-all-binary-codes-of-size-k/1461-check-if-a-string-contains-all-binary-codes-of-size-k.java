class Solution {
    
    public boolean hasAllCodes(String s, int k) {
        
        if(s.length() < k) return false;
        
        int kBinaries = 1 << k;
        
        Set<String> seen = new HashSet<>();
        
        for(int i = k; i <= s.length(); i++){
            
            String sub = s.substring(i - k, i);
            
            if(!seen.contains(sub)){
                seen.add(sub);
                kBinaries--;
                
                if(kBinaries == 0){
                    return true;
                }
            }
        }
        
        return false;
    }
}