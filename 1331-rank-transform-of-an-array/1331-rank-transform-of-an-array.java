class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int [] clone = arr.clone();
        
        Arrays.sort(clone);
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        int rank = 1;
        
        for(int i = 0; i < clone.length; i++){
            if(!indexMap.containsKey(clone[i])){
                indexMap.put(clone[i], rank++);
            }
        }
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = indexMap.get(arr[i]);
        }
        
        return arr;
    }
}