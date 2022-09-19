class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder builder = new StringBuilder();
        Stack<Integer> parens = new Stack<>();
        int appended = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            char currChar = s.charAt(i);
            
            switch(currChar){
                case '(': {
                    parens.add(appended++);
                    builder.append(currChar);
                    break;
                }
                case ')': {
                    if(!parens.isEmpty()){
                      parens.pop();
                      builder.append(currChar); 
                      appended++;
                    }
                    break;
                } 
                default: {
                    builder.append(currChar);
                    appended++;
                }
            }
        }
        
        while(!parens.isEmpty()){
            builder.deleteCharAt(parens.pop());
        }
        
        return builder.toString();
    }
}