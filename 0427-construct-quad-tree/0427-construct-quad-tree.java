/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    
    public Node construct(int[][] grid) {
       return construct(grid, 0, 0, grid.length);
    }
    
    private Node construct(int[][] grid, int row, int col, int dim) {
        
        if(isLeaf(grid, row, col, dim)){
            return new Node(grid[row][col] == 1, true);
        }
        
        Node node = new Node(true, false);
        
        dim /= 2;
        
        node.topLeft = construct(grid, row, col, dim);
        node.topRight = construct(grid, row, col + dim, dim);
        node.bottomLeft = construct(grid, row + dim, col, dim);
        node.bottomRight = construct(grid, row + dim, col + dim, dim);
        
        return node;
    }
    
    private boolean isLeaf(int[][] grid, int row, int col, int dim){
        
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                if(grid[row][col] != grid[row + i][col + j]){
                    return false;
                }
            }
        }
        
        return true;
    }
}