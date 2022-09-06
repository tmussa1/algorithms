class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> s1 = new Stack<>();
        
        for(char c: s.toCharArray()){
            
            if(c == '(' || c == '{' || c == '['){
                s1.push(c);
            }
            
            if(c == ')' || c == '}' || c == ']'){
                
                if(s1.size() == 0){
                    return false;
                }

                char c1 = s1.peek();

                if((c1 == '(' && c == ')') || (c1 =='[' && c == ']') || (c1 == '{' && c == '}')) {
                    s1.pop();
                } else {
                    return false;
                }

            }
        }
        
      return s1.size() == 0;
    }
}