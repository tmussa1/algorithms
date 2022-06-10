class Solution {
    
    public boolean isOneEditDistance(String s, String t) {
        
        int tLength = t.length(), sLength = s.length();
        
        if(Math.abs(tLength - sLength) > 1) {
            return false;
        }
        
        if(s.equals(t)){
            return false;
        }
        
        if(tLength <= 1 && sLength <= 1){
            return true;
        }
        
        int i = 0, j = 0;
        
        while(j < tLength && i < sLength){
            
            char tChar = t.charAt(j);
            char sChar = s.charAt(i);
            
            if(tChar == sChar){
                i++;
                j++;
            } else {
                String insert = s.substring(0, i) + tChar + s.substring(i);
                String remove = s.substring(0, i) + s.substring(i + 1);
                String replace = s.substring(0, i) + tChar + s.substring(i + 1);
                
                System.out.println("I " + insert + " R " + remove + " " + replace);
                if(insert.equals(t) || remove.equals(t) || replace.equals(t)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        
        if(tLength == i + 1 || sLength == j + 1){
            return true;
        }
        
        return false;
    }
}