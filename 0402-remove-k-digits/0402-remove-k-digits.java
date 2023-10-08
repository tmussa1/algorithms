class Solution {
    
    public String removeKdigits(String num, int k) {
        
        Stack<Character> monoStack = new Stack<>();
        
        StringBuilder builder = new StringBuilder();
        
        int index = 0;
        
        while(index < num.length()){
            
            char c = num.charAt(index);
            
            while(!monoStack.isEmpty() && monoStack.peek() > c && k > 0){
                monoStack.pop();
                k--;
            }
            
            monoStack.push(c);
            index++;
        }
        
        while(!monoStack.isEmpty()){
            builder.append(monoStack.pop());
        }
        
        String res = builder.reverse().toString();
        
        res = res.substring(0, res.length() - k).replaceFirst("^0*", "");
        
        return res.length() == 0 ? "0" : res;
    }
}