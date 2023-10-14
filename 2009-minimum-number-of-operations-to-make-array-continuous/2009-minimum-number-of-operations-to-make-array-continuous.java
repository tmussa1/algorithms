class Solution {
    public int minOperations(int[] nums) {
        
        int result = nums.length, left = 0, right = 0, length = nums.length;
        
        Set<Integer> dedup = new HashSet<>();
        
        for(int num: nums){
            dedup.add(num);
        }
        
        int [] nums1 = new int [dedup.size()];
        int count = 0;
        
        for(int num: dedup){
            nums1[count++] = num;
        }
        
        Arrays.sort(nums1);
        
        while(right < nums1.length){
            int sum = nums1[left] + length;
            while(right < nums1.length && nums1[right] < sum){
                right++;
            }
            result = Math.min(result, length - (right - left));
            left++;
        }
        
        return result;
    }
}