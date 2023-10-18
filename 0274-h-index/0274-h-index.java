class Solution {
    
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        
        int length = citations.length;
        
        int left = 0, right = Arrays.stream(citations).sum(), result = 0;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            int index = findIndex(citations, mid);
            
            int citesRight = length - index;
            
            if(citesRight >= mid){
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private int findIndex(int[] citations, int val){
        
        int left = 0, right = citations.length - 1, result = Integer.MAX_VALUE;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            if(citations[mid] == val){
                result = Math.min(result, mid);
                right = mid - 1;
            } else if(citations[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            } 
        }
        
        return Math.min(left, result);
    }
}