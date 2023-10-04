import java.math.*;

class Solution {
    
    public boolean splitString(String s) {
        
        for(int i = 0; i < s.length() - 1; i++){
            
            String prev = s.substring(0, i + 1);
            
            if(splitStringHelper(s, i + 1, prev)) {
               return true;
            }
        }
        
        return false;
    }
    
    private boolean splitStringHelper(String s, int index,
                                      String prev) {
        
        if(index == s.length()){
            return true;
        }
        
        for(int i = index; i < s.length(); i++){
            
            String sub = s.substring(index, i + 1);
            
            if(findNumericValueDiff(prev, sub)){
                if(splitStringHelper(s, i + 1, sub)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean findNumericValueDiff(String s1, String s2){
        
        int index1 = 0, index2 = 0;
        
        while(index1 < s1.length() && s1.charAt(index1) == '0'){
            index1++;
        }
        
        while(index2 < s2.length() && s2.charAt(index2) == '0'){
            index2++;
        }
        
        String newS1 = s1.substring(index1);
        String newS2 = s2.substring(index2);
        
        BigInteger one = new BigInteger(s1);
        BigInteger two = new BigInteger(s2);
        
        return one.subtract(two).equals(BigInteger.ONE);
    }
}