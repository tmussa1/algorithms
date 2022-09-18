class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> intersection = new ArrayList<>();
        
        int num1Index = 0, num2Index = 0;
        
        while(num1Index < nums1.length && num2Index < nums2.length){
            if(nums1[num1Index] < nums2[num2Index]){
                num1Index++;
            } else if(nums2[num2Index] < nums1[num1Index]){
                num2Index++;
            } else {
                intersection.add(nums1[num1Index]);
                num1Index++;
                num2Index++;
            }
        }
        
        int [] result = new int[intersection.size()];
        int count = 0;
        
        for(Integer num: intersection){
            result[count++] = num;
        }
        
        return result;
    }
}