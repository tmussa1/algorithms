class Solution {
    
    public String findDifferentBinaryString(String[] nums) {
        
        Set<String> result = new HashSet<>();
        
        generateBinaries(0, nums.length, result, new StringBuilder());
        
        Set<String> numSet = new HashSet<>();
        
        for(String num: nums){
            numSet.add(num);
        }
        
        for(String res: result){
            if(!numSet.contains(res)){
                return res;
            }
        }
        
        return "";
    }
    
    private void generateBinaries(int index, int length,
                                  Set<String> result,
                                  StringBuilder builder){
        
        if(index == length){
            result.add(new String(builder));
            return;
        }
        
        builder.append('0');
        generateBinaries(index + 1, length, result, builder);
        builder.deleteCharAt(builder.length() - 1);
        builder.append('1');
        generateBinaries(index + 1, length, result, builder);
        builder.deleteCharAt(builder.length() - 1);
    }
}