class LockingTree {
    
    class TreeNode {
        int val, user;
        boolean isLocked;
        TreeNode parent;
        List<TreeNode> children;
    }
    
    Map<Integer, TreeNode> nodeMap;
    
    Map<TreeNode, List<TreeNode>> adjList;

    public LockingTree(int[] parent) {
        
        this.nodeMap = new HashMap<>();
        
        for(int i = 0; i < parent.length; i++) {
            TreeNode node = new TreeNode();
            node.val = i;
            node.isLocked = false;
            node.user = -1;
            this.nodeMap.put(i, node);
        }
        
        this.adjList = buildAdjList(parent, nodeMap);
    }
    
    public boolean lock(int num, int user) {
        
        TreeNode node = nodeMap.get(num);
        
        if(node.isLocked){
            return false;
        }
        
        node.isLocked = true;
        node.user = user;
        
        return true;
    }
    
    public boolean unlock(int num, int user) {
       
        TreeNode node = nodeMap.get(num);
        
        if(!node.isLocked || node.user != user){
            return false;
        }
        
        node.isLocked = false;
        node.user = -1;
        
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        
        TreeNode node = nodeMap.get(num);
        
        TreeNode parent = node;
        
        while(parent != null){
            if(parent.isLocked){
                return false;
            }
            parent = parent.parent;
        }
        
        if(!dfs(adjList, new HashSet<>(), node)){
            return false;
        }
        
        unlockDesc(adjList, new HashSet<>(), node);
        
        node.isLocked = true;
        node.user = user;
        
        return true;
    }
    
    private boolean dfs(Map<TreeNode, List<TreeNode>> adjList,
                        Set<TreeNode> visited,
                        TreeNode node){
        
        if(node.isLocked){
            return true;
        }
        
        if(visited.contains(node)){
            return false;
        }
        
        visited.add(node);
        
        List<TreeNode> neighbors = adjList.get(node);
        
        for(TreeNode neighbor: neighbors){
            if(dfs(adjList, visited, neighbor)){
                return true;
            }
        }
        
        return false;
    }
    
     private void unlockDesc(Map<TreeNode, List<TreeNode>> adjList,
                        Set<TreeNode> visited,
                        TreeNode node){
        
        if(visited.contains(node)){
            return;
        }
         
        node.isLocked = false;
        node.user = -1;
        
        visited.add(node);
        
        List<TreeNode> neighbors = adjList.get(node);
        
        for(TreeNode neighbor: neighbors){
            unlockDesc(adjList, visited, neighbor);
        }
    }
    
    private Map<TreeNode, List<TreeNode>> buildAdjList(int[] parent,
                                          Map<Integer, TreeNode> nodeMap){
        
        Map<TreeNode, List<TreeNode>> adjList = new HashMap<>();
        
        for(Integer key: nodeMap.keySet()){
            adjList.put(nodeMap.get(key), new ArrayList<>());
        }
        
        for(int index = 0; index < parent.length; index++){
            int par = parent[index];
            if(par == -1){
                continue;
            }
            TreeNode parNode = nodeMap.get(par);
            TreeNode childNode = nodeMap.get(index);
            childNode.parent = parNode;
            nodeMap.put(childNode.val, childNode);
            List<TreeNode> children = adjList.get(parNode);
            children.add(childNode);
            adjList.put(parNode, children);
        }
        
        return adjList;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */