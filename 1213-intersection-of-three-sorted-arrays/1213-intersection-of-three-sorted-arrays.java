class Solution {
    
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        populateMap(map, arr1);
        populateMap(map, arr2);
        populateMap(map, arr3);
        
        List<Integer> result = new ArrayList<>();
        
        for(Integer element: map.keySet()){
            if(map.get(element) == 3){
                result.add(element);
            }
        }
        
        Collections.sort(result);
        
        return result;
    }
    
    private void populateMap(Map<Integer, Integer> map, int [] arr){
        
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
    }
}