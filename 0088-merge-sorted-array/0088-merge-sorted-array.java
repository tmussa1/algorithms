class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int end = nums1.length - 1;
        m--;
        n--;
        
        while(end >= 0){
            if(n < 0 || (m >= 0 && nums1[m] > nums2[n])){
                nums1[end] = nums1[m];
                m--;
            } else {
                nums1[end] = nums2[n];
                n--;
            }
            end--;
        }
    }
}