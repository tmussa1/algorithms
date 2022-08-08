/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<Integer, List<Integer>> adjList = constructAdjList(root);
        
        List<Integer> result = null;
        
        for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()){
            if(target.val == entry.getKey()){
                result = nodesDistanceK(target.val, adjList, k);
            }
        }
        
        return result;
    }
    
    List<Integer> nodesDistanceK(int node, Map<Integer, List<Integer>> adjList,
                                 int k){
        
        List<Integer> result = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        
        Set<Integer> visited = new HashSet<>();
        
        int distance = 0;
        
        if(k == 0) {
            result.add(node);
            return result;
        }
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                 int current = queue.poll();
                 visited.add(current);
                
                 List<Integer> neighbors = adjList.get(current);
                
                 for(Integer neighbor: neighbors){
                     if(!visited.contains(neighbor)){
                        queue.offer(neighbor);
                     }
                 }
            }
            
            distance++;
            
            if(distance == k){
                 result.addAll(queue);
                 return result;
            }
        }
        
        return result;
    }
    
    Map<Integer, List<Integer>> constructAdjList(TreeNode root){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
            
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            TreeNode node = queue.poll();
            
            adjList.put(node.val, adjList.getOrDefault(node.val, new ArrayList<>()));
            
            if(node.left != null){
                adjList.get(node.val).add(node.left.val);
                adjList.put(node.left.val, adjList.getOrDefault(node.left.val, new ArrayList<>()));
                adjList.get(node.left.val).add(node.val);
                queue.offer(node.left);
            }
            
            if(node.right != null){
                adjList.get(node.val).add(node.right.val);
                adjList.put(node.right.val, adjList.getOrDefault(node.right.val, new ArrayList<>()));
                adjList.get(node.right.val).add(node.val);
                queue.offer(node.right);
            }
        }
        
        return adjList;
    }
}