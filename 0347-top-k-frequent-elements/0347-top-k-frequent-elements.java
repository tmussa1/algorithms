class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((p1, p2) -> p1.getValue() - p2.getValue());
        
        
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            
            if(queue.size() < k){
               queue.offer(new Pair<>(entry.getKey(), entry.getValue()));
            } else if(queue.peek().getValue() < entry.getValue()) {
               queue.poll();
               queue.offer(new Pair<>(entry.getKey(), entry.getValue()));
            }
        }
               
        
        int [] result = new int[k];
        int index = 0;
        
        while(!queue.isEmpty()){
            result[index] = queue.poll().getKey();
            index++;
        }
        
        return result;
    }
}