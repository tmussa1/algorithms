class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        Set<Integer> result = new HashSet<>();
        
        int num1Index = 0, num2Index = 0;
        
        while(num1Index < nums1.length && num2Index < nums2.length){
            if(nums1[num1Index] < nums2[num2Index]){
                num1Index++;
            } else if(nums1[num1Index] > nums2[num2Index]){
                num2Index++;
            } else {
                result.add(nums1[num1Index]);
                num1Index++;
                num2Index++;
            }
        }
        
        int [] answer = new int[result.size()];
        
        int count = 0;
        
        for(Integer res: result){
            answer[count++] = res;
        }
        
        return answer;
    }
}