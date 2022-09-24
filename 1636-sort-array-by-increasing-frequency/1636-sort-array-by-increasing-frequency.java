class Solution {
    
    public int[] frequencySort(int[] nums) {
        
        PriorityQueue<Tuple> tuples = new PriorityQueue<Tuple>((a, b) -> {
            if(a.frequency == b.frequency) return b.num - a.num;
            return a.frequency - b.frequency;
        });
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            Tuple tuple = new Tuple();
            tuple.num = entry.getKey();
            tuple.frequency = entry.getValue();
            tuples.offer(tuple);
        }
        
        int index = 0;
        
        while(!tuples.isEmpty()){
            Tuple tuple = tuples.poll();
            for(int i = 0; i < tuple.frequency; i++){
                nums[i + index] = tuple.num;
            }
            index += tuple.frequency;
        }
        
        return nums;
    }
    
    class Tuple {
        int num;
        int frequency;
    }
}