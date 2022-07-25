class Solution {
    
    public int missingNumber(int[] arr) {
        
        Map<Integer, Integer> diffMap = new HashMap<>();
        
        int allDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length - 1; i++){
            int diff = Math.abs(arr[i + 1] - arr[i]);
            diffMap.put(diff, diffMap.getOrDefault(diff, 0) + 1);
            allDiff = Math.min(allDiff, diff);
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            int diff = Math.abs(arr[i + 1] - arr[i]);
            if(diffMap.get(diff) == 1){
                if(arr[i + 1] > arr[i]){
                    return arr[i] + allDiff;
                } else {
                    return arr[i] - allDiff;
                }
            } 
        }
        
        return arr[0];
    }
}