class Solution {

    public boolean backspaceCompare(String s, String t) {

        Stack<Character> sStack = processLetters(s);
        Stack<Character> tStack = processLetters(t);

        if(sStack.size() != tStack.size()) return false;

        while(!sStack.isEmpty()){
            if(sStack.pop() != tStack.pop()){
                return false;
            }
        }
        return true;
    }

    private Stack<Character> processLetters(String word){
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < word.length()){
            char c = word.charAt(index);
            if(c == '#'){
                if(!stack.isEmpty()) stack.pop();
                index++; 
                continue;
            }
            stack.push(c);
            index++;
        }
        return stack;
    }
}