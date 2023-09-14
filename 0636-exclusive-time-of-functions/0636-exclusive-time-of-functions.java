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
                    System.out.println("Before peek result " + Arrays.toString(result));
                    result[last[0]] += (Integer.parseInt(logSplit[2]) - end - 1);
                    System.out.println("After peek result " + Arrays.toString(result));
                } 
                timeStack.push(new int [] {Integer.parseInt(logSplit[0]), Integer.parseInt(logSplit[2])});
            } else {
                  int [] last = timeStack.pop();
                  System.out.println("Before pop result " + Arrays.toString(result));
                  result[last[0]] += (Integer.parseInt(logSplit[2]) - Math.max(last[1], end) + 1);
                  System.out.println("After pop result " + Arrays.toString(result));
            }
             end = Integer.parseInt(logSplit[2]);
        }
        
        return result;
    }
}
