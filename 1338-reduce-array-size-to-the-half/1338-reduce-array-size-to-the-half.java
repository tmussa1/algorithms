class Solution {
    public int minSetSize(int[] arr) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int index = 0; index < arr.length; index++){
            countMap.put(arr[index], countMap.getOrDefault(arr[index], 0) + 1);
        }
        
        PriorityQueue<Integer> tuples = new PriorityQueue<Integer>((a, b) -> b - a);
        
        for(Integer value: countMap.values()){
            tuples.offer(value);
        }
        
        int length = arr.length, count = 0;
        
        while(!tuples.isEmpty() && length > arr.length / 2){
            length -= tuples.poll();
            count++;
        }
        
        return count;
    }
    
}