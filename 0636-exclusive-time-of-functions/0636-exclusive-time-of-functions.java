class Solution {
    
    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<int []> timeStack = new Stack<>();
        
        int [] result = new int[n];
        
        int end = 0;
        
        for(int i = 0; i < logs.size(); i++){
            
            String log = logs.get(i);
            
            String [] logSplit = log.split(":");
            
            if(logSplit[1].equals("start")){
                if(!timeStack.isEmpty()){
                    int [] last = timeStack.peek();
                    result[last[0]] += (Integer.parseInt(logSplit[2]) - end - 1);
                } 
                timeStack.push(new int [] {Integer.parseInt(logSplit[0]), Integer.parseInt(logSplit[2])});
            } else {
                  int [] last = timeStack.pop();
                  result[last[0]] += (Integer.parseInt(logSplit[2]) - Math.max(last[1], end) + 1);
            }
             end = Integer.parseInt(logSplit[2]);
        }
        
        return result;
    }
}
