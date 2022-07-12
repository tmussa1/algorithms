class Solution {
    public String reverseWords(String s) {
        
        String [] sentence = s.split(" ");
        
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < sentence.length; i++){
            
            String word = sentence[i].trim();
            
            if(!word.equals("")){
                stack.push(word);
            }
        }
        
        StringBuilder builder = new StringBuilder();
        
        while(!stack.isEmpty()){
            if(stack.size() > 1){
                builder.append(stack.pop() + " ");
                continue;
            }
             builder.append(stack.pop());
        }
        
        return builder.toString();
    }
}