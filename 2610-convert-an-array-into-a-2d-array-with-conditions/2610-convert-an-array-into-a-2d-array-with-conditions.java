class Solution {
    
    public List<List<Integer>> findMatrix(int[] nums) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        List<List<Integer>> result = new ArrayList<>();
            
        for(int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            queue.offer(entry);
        }
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            List<Map.Entry<Integer, Integer>> tempList = new ArrayList<>();
            List<Integer> currList = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                
                Map.Entry<Integer, Integer> curr = queue.poll();
                
                currList.add(curr.getKey());
                
                if(curr.getValue() > 1){
                    curr.setValue(curr.getValue() - 1);
                    tempList.add(curr);
                }
            }
            
            queue.addAll(tempList);
            result.add(currList);
        }
        
        return result;
    }
}