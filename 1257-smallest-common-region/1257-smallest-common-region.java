class Solution {
    
    class Node {
        String val;
        int level;
        Node parent;
    }
    
    Map<String, Node> nodeMap = new HashMap<>();
    
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        
        Map<Node, List<Node>> adjList = buildAdjList(regions);
        
        Node node1 = nodeMap.get(region1);
        Node node2 = nodeMap.get(region2);
        
        Node root = null;
        
        for(String key: nodeMap.keySet()){
            if(nodeMap.get(key).parent == null){
                root = nodeMap.get(key);
            }
        }
        
        setLevel(adjList, root, new HashSet<>(), 1);
        
        while(node1.level > node2.level){
            node1 = node1.parent;
        }
        
        while(node2.level > node1.level){
            node2 = node2.parent;
        }
        
        while(node1 != null && node2 != null && !node1.val.equals(node2.val)) {
            node1 = node1.parent;
            node2 = node2.parent;
        }
        
        return node1.val;
    }
    
    private void setLevel(Map<Node, List<Node>> adjList, Node node,
                          Set<Node> visited, int level){
        
        if(visited.contains(node)){
            return;
        }
        
        visited.add(node);
        
        node.level = level;
        
        for(Node neighbor: adjList.get(node)){
            setLevel(adjList, neighbor, visited, level + 1);
        }
    }
    
    private Map<Node, List<Node>> buildAdjList(List<List<String>> regions){
        
        Map<Node, List<Node>> adjList = new HashMap<>();
        
        for(List<String> region: regions){
            
            String parent = region.get(0);
            Node parentNode = nodeMap.getOrDefault(parent, new Node());
            parentNode.val = parent;
            nodeMap.put(parent, parentNode);
            
            List<Node> children = adjList.getOrDefault(parentNode, new ArrayList<>());
            
            for(int index = 1; index < region.size(); index++){
                String child = region.get(index);
                Node childNode = nodeMap.getOrDefault(child, new Node());
                childNode.val = child;
                childNode.parent = parentNode;
                children.add(childNode);
                adjList.put(childNode, adjList.getOrDefault(childNode, new ArrayList<>()));
                nodeMap.put(child, childNode);
            }
            
            adjList.put(parentNode, children);
        }
        
        return adjList;
    }
}