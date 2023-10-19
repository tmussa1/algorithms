class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {

        return (int) countGoodStrings(low, high, zero, one, 0, new HashMap<>());
    }
    
    private long countGoodStrings(int low, int high, int zero, int one, int length,
                                 Map<Integer, Long> memo){
        
        long mod = 1_000_000_007;
        
        if(length > high){
            return 0; 
        }
        
        if(memo.containsKey(length)){
            return memo.get(length);
        }
        
        long result = 0;
        
        length += zero;
        result += ((length >= low && length <= high) ? 1 : 0) + (countGoodStrings(low, high, zero, one, length, memo) % mod);
        length -= zero;
        length += one;
        result += ((length >= low && length <= high) ? 1 : 0) + (countGoodStrings(low, high, zero, one, length, memo) % mod); 
        length -= one;
        
        memo.put(length, result % mod);
        
        return memo.get(length);
    }
}