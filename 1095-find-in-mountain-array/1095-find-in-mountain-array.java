/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int length = mountainArr.length();
        
        int left = 0, right = length - 1, maxIndex = 0;
        
        while(left <= right) {
            
            int mid = left + ((right - left) / 2);
            
            int val = mountainArr.get(mid);
            
            if(mid - 1 >= 0 && mountainArr.get(mid - 1) < val  && val > mountainArr.get(mid + 1)){
                maxIndex = mid;
                break;
            } else if(mid - 1 >= 0 && mountainArr.get(mid - 1) > val){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        left = 0;
        right = maxIndex;
        
        while(left <= right) {
            
            int mid = left + ((right - left) / 2);
            
            int val = mountainArr.get(mid);
            
            if(val == target){
               return mid;
            } else if(val < target){
               left = mid + 1;
            } else {
               right = mid - 1;
            }
        }
        
        left = maxIndex + 1;
        right = length - 1;
        
        while(left <= right) {
            
            int mid = left + ((right - left) / 2);
            
            int val = mountainArr.get(mid);
            
            if(val == target){
               return mid;
            } else if(val < target){
               right = mid - 1;
            } else {
               left = mid + 1;
            }
        }
        
        return -1;
    }
}