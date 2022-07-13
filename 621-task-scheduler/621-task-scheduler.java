class Solution {
    
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character, Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < tasks.length; i++){
            char c = tasks[i];
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
            if(a.time == b.time){
                return a.count - b.count;
            }
            return a.time - b.time;
        });
        
        Map<Character, Integer> sortedMap = countMap.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                     (e1, e2) -> e1, LinkedHashMap::new));
        
        int index = 0;
        
        for(Map.Entry<Character, Integer> entry: sortedMap.entrySet()){
            queue.offer(new Node(entry.getKey(), entry.getValue(), index++));
        }
        
        int time = 0;
        
        while(!queue.isEmpty()){
            
            if(time >= queue.peek().time){
                
                Node task = queue.poll();
                
                task.count -= 1;
                
                if(task.count > 0){
                    task.time += (n + 1);
                    queue.offer(task);
                }
            }
            
            time++;
        }
        
        return time;
    }
    
    class Node {
        char task;
        int count;
        int time;
        
        Node(char task, int count, int time){
            this.task = task;
            this.count = count;
            this.time = time;
        }
    }
}