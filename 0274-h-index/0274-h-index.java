class Solution {
    
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        
    //    if(citations[0] > citations.length) return citations[0] == 0 ? 0 : citations.length;
        
        int length = citations.length;
        
        int left = 0, right = Arrays.stream(citations).sum(), result = 0;
        
  //      System.out.println("Arr " + Arrays.toString(citations));
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            int index = findIndex(citations, mid);
            
            int val = length - index;
            
       //     System.out.println("Mid " + mid + " index " + index + " val " + val);
            
            if(val >= mid){
                result = Math.max(result, mid);
        //        System.out.println("Res " + result);
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
            
       //     System.out.println("MId here " + mid + " val " + val);
            
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