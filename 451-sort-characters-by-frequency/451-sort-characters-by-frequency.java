class Solution {
    
    public String frequencySort(String s) {
        
        Map<Character, Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> b.count - a.count);
        
        for(Map.Entry<Character, Integer> entry: countMap.entrySet()){
            queue.offer(new Tuple(entry.getKey(), entry.getValue()));
        }
        
        String result = "";
        
        while(!queue.isEmpty()){
            
            Tuple tuple = queue.poll();
       
            
            String charac = tuple.c + "";
            
            charac = charac.repeat(tuple.count);
            
            result += charac;
        }
        
        return result;
    }
    
    class Tuple {
        
        char c;
        int count;
        
        Tuple(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
}