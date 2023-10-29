class Solution {
    
    public int maximalRectangle(char[][] matrix) {
        
        int area = 0, rows = matrix.length, cols = matrix[0].length;
        
        int [] heights = new int [matrix[0].length];
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(matrix[row][col] == '0'){
                    heights[col] = 0;
                } else {
                    heights[col] += 1;
                }
            }
            area = Math.max(area, largest(heights));
        }
        
        return area;
    }
    
    private int largest(int [] heights){
        
        Stack<Tuple> monoStack = new Stack<>();

        int index = 0, result = 0;

        while(index < heights.length){

            int curr = heights[index], ind = index;

            while(!monoStack.isEmpty() && curr < monoStack.peek().height){
                Tuple top = monoStack.pop();
                ind = Math.min(ind, top.index);
                result = Math.max(result, (index - top.index) * top.height);
            }

            Tuple tuple = new Tuple();
            tuple.index = ind;
            tuple.height = curr;
            monoStack.push(tuple);
            index++;
        }

        while(!monoStack.isEmpty()){
             Tuple top = monoStack.pop();
             result = Math.max(result, (heights.length - top.index) * top.height);
        }

        return result;
    }
}

   class Tuple {
        int index;
        int height;
    }