class SparseVector {
    
    int [] nums;
    
    SparseVector(int[] nums) {
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
        int [] currNums = vec.nums;
        int result = 0;
        
        for(int i = 0; i < nums.length; i++){
            result += (nums[i] * currNums[i]);
        }
        
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);