class Solution {
    
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> result = new ArrayList<>();
            
        Set<Integer> num1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> num2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> interSet = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        
        interSet.retainAll(num2Set);
        
        num1Set.removeAll(interSet);
        num2Set.removeAll(interSet);
        
        result.add(new ArrayList<>(num1Set));
        result.add(new ArrayList<>(num2Set));
        
        return result;
    }
}