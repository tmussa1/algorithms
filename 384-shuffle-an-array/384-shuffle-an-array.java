class Solution {

    int [] nums;
    Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int[] reset() {
        return this.nums;
    }
    
    public int[] shuffle() {
        
        int [] clone = nums.clone();
        
        int right = clone.length - 1;
        
        for(int index = right; index >= 0; index--){
            int randIndex = this.random.nextInt(index + 1);
            swap(clone, randIndex, index);
        }
        
        return clone;
    }
    
    private void swap(int [] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */