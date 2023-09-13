/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        if(root == null) return result;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            List<Integer> currList = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                if(curr != null) {
                   currList.add(curr.val);
                   if(curr.children.size() > 0) queue.addAll(curr.children);
                }
            }
            
            result.add(currList);
        }
        
        return result;
    }
}