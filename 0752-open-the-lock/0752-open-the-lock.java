class Solution {
    
    public int openLock(String[] deadends, String target) {
        
        String start = "0000";
        
        Set<String> deadSet = new HashSet<>();
        
        for(String deadend: deadends){
            deadSet.add(deadend);
        }
        
        if(deadSet.contains(start)){
            return -1;
        }
        
        Set<String> visited = new HashSet<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        
        visited.add(start);
        
        int rolls = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int j = 0; j < size; j++){
                
                String curr = queue.poll();
                
                if(curr.equals(target)){
                    return rolls;
                }
                
                for(int i = 0; i < curr.length(); i++){
                    
                   char c = curr.charAt(i);
                   char next = '0', prev = '0';
                    
                   if(c == '9'){
                      next = '0';
                      prev = '8';
                   } else if(c == '0'){
                       next = '1';
                       prev = '9';
                   } else {
                       next = ((char) (c + 1));
                       prev = ((char) (c - 1));
                   }
                        
                   String sub = curr.substring(0, i) + next + curr.substring(i + 1);

                   if(!visited.contains(sub) && !deadSet.contains(sub)){
                       queue.offer(sub);
                       visited.add(sub);
                   }
                    
                   String sub2 = curr.substring(0, i) + prev + curr.substring(i + 1);

                   if(!visited.contains(sub2) && !deadSet.contains(sub2)){
                       queue.offer(sub2);
                       visited.add(sub2);
                   }
                }
            }
            
            rolls++;
        }
        
        return -1;
    }
}