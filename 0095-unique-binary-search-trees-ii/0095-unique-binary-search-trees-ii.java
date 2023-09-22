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

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(n, 1, n, new HashMap<>());
    }

    private List<TreeNode> generateTrees(int n, int start, int end, Map<String, List<TreeNode>> memo){

        String key = start + "," + end;

        if(!memo.containsKey(key)){

            List<TreeNode> result = new ArrayList<>();

            if(start > end){
                result.add(null);
                return result;
            }

            for(int i = start; i <= end; i++){

                List<TreeNode> leftTree = generateTrees(n, start, i - 1, memo);
                List<TreeNode> rightTree = generateTrees(n, i + 1, end, memo);

                for(TreeNode leftNode: leftTree){
                    for(TreeNode rightNode: rightTree){
                        result.add(new TreeNode(i, leftNode, rightNode));
                    }
                }
            }

            memo.put(key, result);
        }

        return memo.get(key);
    }
}