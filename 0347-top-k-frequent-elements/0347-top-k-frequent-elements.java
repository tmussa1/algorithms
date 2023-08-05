class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            queue.offer(entry);
        }
        
        int index = 0;
        
        int [] result = new int[k];
        
        while(!queue.isEmpty() && index < k){
            result[index++] = queue.poll().getKey();
        }
        
        return result;
    }
}