/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    
    public Node inorderSuccessor(Node root) {
        
        if(root == null) return null;
        
        
        if(root.right != null){
            
            Node trav = root.right;
            
            while(trav != null && trav.left != null){
                trav = trav.left;
            }
            
            return trav;
        }
        
        if(root.parent != null){
            
            Node trav = root;
            
            while(trav != null && trav.parent != null && trav.parent.right == trav){
                trav = trav.parent;
            }
            
            return trav.parent;
        }
        
        return null;
    }
}