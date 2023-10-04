import java.math.*;

class Solution {
    
    public boolean splitString(String s) {
        
        for(int i = 0; i < s.length() - 1; i++){
            
            String prev = s.substring(0, i + 1);
            
            if(splitStringHelper(s, i + 1, new LinkedList<>(), prev)) {
               return true;
            }
        }
        
        return false;
    }
    
    private boolean splitStringHelper(String s, int index,
                                      LinkedList<String> currList,
                                      String prev) {
        
        if(index == s.length()){
           // System.out.println("ind " + index);
            return true;
        }
        
        for(int i = index; i < s.length(); i++){
            
            String sub = s.substring(index, i + 1);
            
            if(findNumericValueDiff(prev, sub)){
                currList.add(sub);
            //    System.out.println("Prev " + prev + " sub " + sub);
                if(splitStringHelper(s, i + 1, currList, sub)) {
                    return true;
                }
                currList.removeLast();
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
        
//         if(newS1.isEmpty() && newS2.isEmpty()) return false;
        
//         if(newS2.isEmpty()) return s2.equals("0") && newS1.equals("1");
        
        BigInteger one = new BigInteger(s1);
        BigInteger two = new BigInteger(s2);
        
        System.out.println("One " + one + " two " + two + " diff " + one.subtract(two).equals(BigInteger.ONE));
        
        return one.subtract(two).equals(BigInteger.ONE);
    }
}