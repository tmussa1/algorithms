/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    public Node treeToDoublyList(Node root) {
        
        if(root == null) return root;
        
        List<Node> nodes = new ArrayList<>();
        
        inorderTraversal(root, nodes);
        
        Node firstNode = nodes.get(0);
        
        Node answer = firstNode;
        
        Node lastNode = nodes.get(nodes.size() - 1);
        
        firstNode.left = lastNode;
        lastNode.right = firstNode;
        
        Node nextNode = null;
        
        for(int index = 1; index < nodes.size(); index++){
            nextNode = nodes.get(index);
            firstNode.right = nextNode;
            nextNode.left = firstNode;
            firstNode = firstNode.right;
        }
        
        return answer;
    }
    
    private void inorderTraversal(Node root, List<Node> nodes){
        
        if(root == null) return;
        
        inorderTraversal(root.left, nodes);
        
        nodes.add(root);
        
        inorderTraversal(root.right, nodes);
    }
}