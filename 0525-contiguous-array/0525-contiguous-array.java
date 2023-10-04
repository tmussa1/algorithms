class Solution {

    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);

        int sumOnes = 0, length = 0;

        for(int i = 0; i < nums.length; i++){
            sumOnes += nums[i] == 1 ? 1 : -1;
            if(prefixMap.containsKey(sumOnes)){
                length = Math.max(length, i - prefixMap.get(sumOnes));
            } else {
                prefixMap.put(sumOnes, i);
            }
        }

        return length;
    }
}