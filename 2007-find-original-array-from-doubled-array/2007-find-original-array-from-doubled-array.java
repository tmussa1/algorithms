class Solution {
    
    public int[] findOriginalArray(int[] changed) {
        
        Arrays.sort(changed);
        
        int length = changed.length;
        
        if(length % 2 == 1) return new int [] {};
        
        Map<Integer, Integer> all = new HashMap<>();
        
        int [] result = new int[length / 2];
        
        int index = 0;
        
        for(int i = 0; i < length; i++){
            int num = changed[i];
            all.put(num, all.getOrDefault(num, 0) + 1);
        }
        
        for(int i = 0; i < length; i++){
            int num = changed[i];  
            if(all.containsKey(num * 2) && all.containsKey(num)){
                all.put(num, all.get(num) - 1);
                if(all.getOrDefault(num, 0) == 0){
                    all.remove(num);
                }
                if(!all.containsKey(num * 2)){
                    continue;
                }
                all.put(num * 2, all.get(num * 2) - 1);
                if(all.getOrDefault(num * 2, 0) == 0){
                    all.remove(num * 2);
                }
                result[index++] = num;
            }
        }
        
        return all.isEmpty() ? result : new int [] {};
    }
}