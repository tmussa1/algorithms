class Solution {
    
    public String reorganizeString(String s) {
        
        Map<Character, Integer> countMap = new HashMap<>();
        
        char [] sArr = s.toCharArray();
        
        for(char c: sArr){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for(Map.Entry<Character, Integer> entry: countMap.entrySet()){
            queue.offer(entry);
        }
        
        Map.Entry<Character, Integer> prevEntry = null;
        
        StringBuilder builder = new StringBuilder();
        
        while(!queue.isEmpty()){
            
            Map.Entry<Character, Integer> entry = queue.poll();
            
            entry.setValue(entry.getValue() - 1);
            
            builder.append(entry.getKey());
            
            if(prevEntry != null){
                queue.offer(prevEntry);
                prevEntry = null;
            }
            
            if(entry.getValue() > 0){
                prevEntry = entry;
            }
        }
        
        return builder.length() == s.length() ? builder.toString() : "";
    }
}