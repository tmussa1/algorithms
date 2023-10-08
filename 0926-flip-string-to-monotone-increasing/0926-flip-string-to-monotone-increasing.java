class Solution {
    public int minFlipsMonoIncr(String s) {
        
        char [] sArr = s.toCharArray();
        
        return minFlipsMonoIncr(sArr, 0, s.length(), true, new HashMap<>());
    }
    
    private int minFlipsMonoIncr(char [] sArr, int index, int length, boolean isZero,
                                 Map<String, Integer> memo){
        
        String key = isZero + "," + index;
        
        if(index == length){
            return 0;
        }
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int result = Integer.MAX_VALUE;
        
        char c = sArr[index];
        
        if(isZero){
            if(c == '0'){
                return minFlipsMonoIncr(sArr, index + 1, length, isZero, memo);
            } else {
             //   sArr[index] = '0';
                int changed = 1 + minFlipsMonoIncr(sArr, index + 1, length, isZero, memo);
            //    sArr[index] = '1';
                int unchanged = minFlipsMonoIncr(sArr, index + 1, length, !isZero, memo);
                result = Math.min(result, Math.min(changed, unchanged));
            }
        } else {
            if(c == '1'){
                return minFlipsMonoIncr(sArr, index + 1, length, isZero, memo);
            } else {
              //  sArr[index] = '1';
                int changed = 1 + minFlipsMonoIncr(sArr, index + 1, length, isZero, memo);
              //  sArr[index] = '0';
                result = Math.min(result, changed);
            }
        }
        
        memo.put(key, result);
        
        
        return result;
    }
}