class Solution {
    
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int diff = Integer.MAX_VALUE, rotations = 0, length = tops.length;
        
        Map<Integer, Integer> topMap = populateCount(tops);
        Map<Integer, Integer> bottomMap = populateCount(bottoms);
        
        PriorityQueue<Map.Entry<Integer, Integer>> topQueue = populateQueue(topMap);
        PriorityQueue<Map.Entry<Integer, Integer>> bottomQueue = populateQueue(bottomMap);
        
        while(!topQueue.isEmpty()){
            
            Map.Entry<Integer, Integer> entry = topQueue.poll();
            
            for(int i = 0; i < length; i++){
                if(tops[i] == entry.getKey()){
                    continue;
                }
                if(bottoms[i] == entry.getKey()){
                    rotations++;
                }
            }
            
            if(rotations + entry.getValue() >= length){
                diff = Math.min(diff, rotations);
                break;
            }
            
            rotations = 0;
        }
        
        rotations = 0;
        
        while(!bottomQueue.isEmpty()){
            
            Map.Entry<Integer, Integer> entry = bottomQueue.poll();
            
            for(int i = 0; i < length; i++){
                if(bottoms[i] == entry.getKey()){
                    continue;
                }
                if(tops[i] == entry.getKey()){
                    rotations++;
                }
            }
            
            if(rotations + entry.getValue() >= length){
                diff = Math.min(diff, rotations);
                break;
            }
            
            rotations = 0;
        }
        
        return diff == Integer.MAX_VALUE ? -1 : diff;
    }
    
    PriorityQueue<Map.Entry<Integer, Integer>> populateQueue(Map<Integer, Integer> map){
        
         PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            queue.offer(entry);
        }
        
        return queue;
    }
    
    Map<Integer, Integer> populateCount(int [] dominoes){
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int domino: dominoes){
            countMap.put(domino, countMap.getOrDefault(domino, 0) + 1);
        }
        
        return countMap;
    }
}