/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        List<Integer> dims = binaryMatrix.dimensions();
        
        int rows = dims.get(0), cols = dims.get(1);
        
        int row = 0, result = Integer.MAX_VALUE;
        
        while(row < rows){
            
            int col = binarySearch(binaryMatrix, 0, cols - 1, row);
            cols = Math.min(col, cols);
            result = Math.min(result, col);
            
            row++;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int binarySearch(BinaryMatrix binaryMatrix, int left, int right, int row){
        
        int result = Integer.MAX_VALUE;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            int val = binaryMatrix.get(row, mid);
            
            if(val == 1){
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
}