class Solution {
    
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int [] result = new int[tasks.length];
        
        PriorityQueue<Pair<Integer, Integer>> available = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> {
            if(a.getKey().equals(b.getKey())){
                return a.getValue() - b.getValue();
            }
            return a.getKey() - b.getKey();
        });
        
        for(int index = 0; index < servers.length; index++){
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(servers[index], index);
            available.offer(pair);
        }
        
        PriorityQueue<int []> unavailable = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                if(a[1] == b[1]){
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int index = 0, time = 0;
        
        while(index < tasks.length){
            
            time = Math.max(time, index);
            
            if(available.isEmpty()){
                time = unavailable.peek()[0];
            } 
            
            while(!unavailable.isEmpty() && time >= unavailable.peek()[0]){
                int [] curr = unavailable.poll();
                available.offer(new Pair<Integer, Integer>(curr[1], curr[2]));
            }  
            
            Pair<Integer, Integer> pair = available.remove();
            result[index] = pair.getValue();
            unavailable.offer(new int [] {tasks[index] + time, pair.getKey(), pair.getValue()});
            index++;
        }
        
        return result;
    }
}