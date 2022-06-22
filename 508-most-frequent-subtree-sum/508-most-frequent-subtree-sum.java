/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        
        Map<Integer, Integer> subtreeSumMap = new HashMap<>();
        TreeNode sumRoot = findSum(root, subtreeSumMap);
        int max = findMax(subtreeSumMap);
    
        List<Integer> result = new ArrayList<Integer>();
        
        for(Map.Entry<Integer,Integer> entry: subtreeSumMap.entrySet()){
            if(entry.getValue() == max){
                result.add(entry.getKey());
            }
        }
        
        return result.stream().mapToInt(a -> a).toArray();
    }
    
    int findMax(Map<Integer, Integer> subtreeSumMap){
        
        int max = Integer.MIN_VALUE;
        
        for(Map.Entry<Integer,Integer> entry: subtreeSumMap.entrySet()){
            
            if(entry.getValue() >= max){
                max = entry.getValue();
            }
        }
        
        return max;
    }
    
    TreeNode findSum(TreeNode root, Map<Integer, Integer> subtreeMap){
        
        if(root == null){
            return null;
        }
        
        TreeNode left = findSum(root.left, subtreeMap);
        TreeNode right = findSum(root.right, subtreeMap);
        
        if(left != null){
            root.val += left.val;
        }
        
        if(right != null){
            root.val += right.val;
        }
        
        subtreeMap.put(root.val, subtreeMap.getOrDefault(root.val, 0) + 1);
        
        return root;
    }
}