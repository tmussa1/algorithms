class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int left = m - 1, right = n - 1, end = m + n - 1;
        
        while(end >= 0){
            
            if(left < 0 || (right >= 0 && nums2[right] > nums1[left])){
                nums1[end] = nums2[right];
                end--;
                right--;
            } else {
                nums1[end] = nums1[left];
                end--;
                left--;
            }
        }
    }
}