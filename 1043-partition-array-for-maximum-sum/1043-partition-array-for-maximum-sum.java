class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return partition(arr, k, 0, new Integer[arr.length]);
    }
    
    private int partition(int[] arr, int k, int index, Integer [] memo){
        
        if(index == arr.length){
            return 0;
        }
        
        if(memo[index] != null){
            return memo[index];
        }
        
        int length = 1, result = Integer.MIN_VALUE, product = Integer.MIN_VALUE;
        
        for(int i = index; i < Math.min(arr.length, index + k); i++){
            product = Math.max(product, arr[i]);
            int res = product * length + partition(arr, k, i + 1, memo);
            length++;
            result = Math.max(res, result);
        }
        
        memo[index] = result;
        
        return result;
    }
}