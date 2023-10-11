class Solution {
    
    public int maxProduct(String s) {
        
        long length = 1 << s.length();
        
        int result = 0;
        
        Map<Long, String> maskMap = new HashMap<>();
        
        for(long mask = 1; mask < length; mask++){
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if((mask & (1 << i)) != 0) {
                    builder.append(s.charAt(i));
                }
            }
            
            if(builder.toString().equals(builder.reverse().toString())){
                maskMap.put(mask, builder.toString());
            }
        }
        
        for(Long key1: maskMap.keySet()){
            for(Long key2: maskMap.keySet()){
                if((key1 & key2) == 0){
                    result = Math.max(result, maskMap.get(key1).length() * maskMap.get(key2).length());
                }
            }
        }
        
        return result;
    }
}