class Solution {
    
    public String truncateSentence(String s, int k) {
        
        StringBuilder builder = new StringBuilder();
        
        String [] strSplit = s.split(" ");
        
        int index = 0;
        
        while(index < k){
            builder.append(strSplit[index++]);
            builder.append(" ");
        }
        
        return builder.toString().trim();
    }
}