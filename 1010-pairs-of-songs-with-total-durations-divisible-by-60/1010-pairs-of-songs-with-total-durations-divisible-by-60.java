class Solution {
    
    public int numPairsDivisibleBy60(int[] time) {
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, 0);
        
        int count = 0;
        
        for(int i = 0; i < time.length; i++){
            int key = time[i] % 60;
            if(indexMap.containsKey(60 - key)){
                count += indexMap.get(60 - key);
                System.out.println(key + " key " + indexMap.get(60 - key) + " I " + i);
            } else if(key == 0){
                  count += indexMap.get(0);
            }
            indexMap.put(key, indexMap.getOrDefault(key, 0) + 1);
        }
        
        return count;
    }
}