class Solution {
    
    
    public String decodeString(String s) {
        
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        
        char []chArr = s.toCharArray();
        
        int index = 0;
        
        // 1 - iterate through each characters
        // 2 - if digit, push to numStack
        // 3 - if characters or [, push to charStack
        // 4 - if ], pop from charStack until we get to [, pop from numStack once and repeat
        // what we popped from charSTack however many times as the popped element from numStack
        
        while(index < s.length()){
            
            char c = chArr[index];
                    
            if(Character.isDigit(c)) {

                int firstIndex = index;

                while(index < s.length() && Character.isDigit(chArr[index])){
                    index++;
                }

                int lastIndex = index;

                String sDigit = s.substring(firstIndex, lastIndex);

                numStack.push(Integer.parseInt(sDigit));
                
            } else if ( c == ']') {
                    
                int num = numStack.pop();

                StringBuilder builder = new StringBuilder();

                while(!charStack.isEmpty() && charStack.peek() != '['){
                    builder.append(charStack.pop() + "");
                }

                charStack.pop();

                String reversed = builder.reverse().toString();

                reversed = reversed.repeat(num);

                char [] charArrayInput = reversed.toCharArray();

                for(int i = 0; i < charArrayInput.length; i++){
                    charStack.push(charArrayInput[i]);
                }
                
                index++;
                
            } else  {
                charStack.push(c);
                index++;
            }   
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!charStack.isEmpty()){
            result.append(charStack.pop());
        }
        
        return result.reverse().toString();
    }
}
/**

numStack 3 2

charStack [a [c

charStack [acc

"3[a2[c]]"

**/