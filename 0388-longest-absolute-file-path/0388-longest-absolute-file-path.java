class Solution {
    public int lengthLongestPath(String input) {
        
        String [] inputSplit = input.split("\n");
        
        int countOfWords = 0, length = 0, result = 0;
        
        Stack<String> stack = new Stack<>();
        Stack<Integer> tabCount = new Stack<>(); 
        
        for(String word: inputSplit){
           int index = word.lastIndexOf("\t");
           word = word.substring(Math.max(0, index + 1));
           if(tabCount.isEmpty() || index > tabCount.peek()){
               if(word.indexOf(".") != -1){
                   result = Math.max(length + word.length() + countOfWords, result);
               } else {
                    stack.push(word);
                    countOfWords++;
                    length += word.length();
                    tabCount.push(index); 
               }
           } else {
               while(!tabCount.isEmpty() && index <= tabCount.peek()){
                   tabCount.pop();
                   String word1 = stack.pop();
                   countOfWords--;
                   length -= word1.length();
               }
               if(word.indexOf(".") != -1){
                   result = Math.max(length + word.length() + countOfWords, result);
               } else {
                    stack.push(word);
                    countOfWords++;
                    length += word.length();
                    tabCount.push(index); 
               }
           }
        }
            
        return result;
    }
}