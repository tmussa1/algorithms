class Solution {
    
    
    public boolean rotateString(String s, String goal) {
        
        if(s.length() != goal.length()){
            return false;
        }
        
        if(s.length() == 1) {
           if(!s.equals(goal)){
             return false;
           } else {
             return true;
           }
        }
        
        s = s + s;
        
//         StringBuilder target = new StringBuilder();
//         target.append(s.substring(s.length() - 1));
//         target.append(s.substring(0, s.length() - 1));
        
//         while(!s.equals(target.toString())){
            
//             if(goal.equals(target.toString())) {
//                 return true;
//             }
            
//             int length = target.length() - 1;
            
//             char c = target.charAt(length);
            
//             target.deleteCharAt(length);
            
//         }
        
//         System.out.println(target.toString());
        
        return s.indexOf(goal) != -1;
    }
}