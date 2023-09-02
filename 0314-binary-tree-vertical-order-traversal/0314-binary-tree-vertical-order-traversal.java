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
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        TreeMap<Integer, List<Integer>> resultMap = new TreeMap<>();
        
        Map<Pair<Integer, Integer>, ArrayList<Integer>> levelMap = new HashMap<>();
        
        dfs(root, levelMap, 0, 0);
        
        PriorityQueue<Map.Entry<Pair<Integer, Integer>, ArrayList<Integer>>> queue = new PriorityQueue<>((a, b) -> {
            if(a.getKey().getKey() == b.getKey().getKey()){
                return a.getKey().getValue() - b.getKey().getValue();
            }
            return a.getKey().getKey() - b.getKey().getKey();
        });
        
        for(Map.Entry<Pair<Integer, Integer>, ArrayList<Integer>> entry: levelMap.entrySet()){
            queue.offer(entry);
        }
        
        while(!queue.isEmpty()){
            
            Map.Entry<Pair<Integer, Integer>, ArrayList<Integer>> entry = queue.poll();
            List<Integer> lst = resultMap.getOrDefault(entry.getKey().getKey(), new ArrayList<>());
            lst.addAll(entry.getValue());
            resultMap.put(entry.getKey().getKey(), lst);
        }
        
        for(Integer res: resultMap.keySet()){
            result.add(resultMap.get(res));
        }
        
        return result;
    }
    
    private void dfs(TreeNode root, Map<Pair<Integer, Integer>, ArrayList<Integer>> levelMap,
                     int level, int y){
        if(root == null) return;
        
        Pair<Integer, Integer> pair = new Pair(level, y);
        
        ArrayList<Integer> set = levelMap.getOrDefault(pair, new ArrayList<>());
        set.add(root.val);
        levelMap.put(pair, set);
        
        dfs(root.left, levelMap, level - 1, y + 1);
        dfs(root.right, levelMap, level + 1, y + 1);
    }
}