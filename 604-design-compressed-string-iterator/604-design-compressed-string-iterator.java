class StringIterator {

    private int size = 0, repeat = 0;
    
    private char [] chArr;
    
    private char currentChar;
    
    private String compressedString;
    
    private Queue<Integer> queue;
    private Queue<Character> queueChars;
    
    public StringIterator(String compressedString) {
        this.chArr = compressedString.toCharArray();
        this.queue = new LinkedList<>();
        this.queueChars =  new LinkedList<>();
        this.size = compressedString.length();
        
        for(int i = 0; i < size; ){
            
           char c = this.chArr[i];
        
           if(Character.isDigit(c)){
               
               int firstIndex = i;
               
               while(firstIndex < size && Character.isDigit(this.chArr[firstIndex])) {
                   firstIndex++;
               }
               
               int lastIndex = firstIndex;
               
               String digits = compressedString.substring(i, lastIndex);
               
               queue.offer(Integer.parseInt(digits));
               
               i = lastIndex;
           } else {
               queueChars.offer(c);
               i++;
           }
        }
    }
    
    public char next() {
        
        boolean nothingFound = repeat <= 0 && queueChars.isEmpty() && queue.isEmpty();
        
        if(repeat <= 0 && !queueChars.isEmpty() && !queue.isEmpty()){
            this.currentChar = queueChars.poll();
            this.repeat = queue.poll();
        } 
        
        this.repeat--;
        
        return nothingFound ? ' ' : this.currentChar;
    }
    
    public boolean hasNext() {
        return (!this.queue.isEmpty() && !this.queueChars.isEmpty()) || this.repeat > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */