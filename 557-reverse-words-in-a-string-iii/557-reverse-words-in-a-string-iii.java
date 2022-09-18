class Solution {
    
    public String reverseWords(String s) {
        
        String [] split = s.split(" ");
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < split.length - 1; i++){
            String word = split[i];
            String reversed = new StringBuilder(word).reverse().toString();
            builder.append(reversed + " ");
        }
        
        String word = split[split.length - 1];
        String reversed = new StringBuilder(word).reverse().toString();
        builder.append(reversed);
        
        return builder.toString();
    }
}