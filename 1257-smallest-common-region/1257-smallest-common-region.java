class Solution {
    
    class Node {
        String val;
        int level = 0;
        Node parent;
    }
    
    Map<String, Node> nodeMap = new HashMap<>();
    
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        
        buildAdjList(regions);
        
        Node node1 = nodeMap.get(region1);
        Node node2 = nodeMap.get(region2);
        
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
    
    private void buildAdjList(List<List<String>> regions){
        
        for(List<String> region: regions){
            
            String parent = region.get(0);
            Node parentNode = nodeMap.getOrDefault(parent, new Node());
            parentNode.val = parent;
            nodeMap.put(parent, parentNode);
            
            for(int index = 1; index < region.size(); index++){
                String child = region.get(index);
                Node childNode = nodeMap.getOrDefault(child, new Node());
                childNode.val = child;
                childNode.level = parentNode.level + 1;
                childNode.parent = parentNode;
                nodeMap.put(child, childNode);
            }
        }
    }
}