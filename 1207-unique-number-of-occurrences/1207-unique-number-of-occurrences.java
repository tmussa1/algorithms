class Solution {
    
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer,Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }
        
        Set<Integer> removeDuplicates = new HashSet<>(countMap.values());
        
        return removeDuplicates.size() == countMap.values().size();
    }
}