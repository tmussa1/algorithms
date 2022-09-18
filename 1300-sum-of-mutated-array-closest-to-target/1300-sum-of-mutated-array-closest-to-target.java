class Solution {
    
    public int findBestValue(int[] arr, int target) {
        
        Arrays.sort(arr);
        
        int left = 0, right = arr[arr.length - 1];
        
        long smallestDiff = Long.MAX_VALUE, diff = Long.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            long sum = findSum(arr, mid);
            
            diff = Math.abs(target - sum);
            
            if(diff < smallestDiff){
                smallestDiff = diff;
                answer = mid;
            } else if(diff == smallestDiff){
                answer = Math.min(answer, mid);
            }
            
            if(sum > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private long findSum(int[] arr, int pivot){
        
        long sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > pivot){
                sum += pivot;
            } else {
                sum += arr[i];
            }
        }
        
        return sum;
    }
}