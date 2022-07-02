class Solution {
    
    public int compress(char[] chars) {
        
        Queue<Integer> queueNums = new LinkedList<>();
        Queue<Character> queueChars = new LinkedList<>();
        
        int index = 0;
        
        while(index < chars.length){
            
            char c = chars[index];
            
            int firstIndex = index;
            
            while(index + 1 < chars.length && chars[index] == chars[index + 1]){
                index++;
            }
            
            queueNums.offer(index - firstIndex + 1);
            queueChars.offer(c);
            
            index++;
        }
        
        int resultIndex = 0;
        
        while(!queueNums.isEmpty() && !queueChars.isEmpty()){
            
            int count = queueNums.poll();
            char c = queueChars.poll();
            
            chars[resultIndex] = c;
            
            resultIndex++;
            
            String digits = String.valueOf(count);
            
            if(count > 1){
                for(int i = 0; i < digits.length(); i++){
                    chars[resultIndex] = digits.charAt(i);
                    resultIndex++;
                }
            } 
        }
        
        return resultIndex;
    }
}