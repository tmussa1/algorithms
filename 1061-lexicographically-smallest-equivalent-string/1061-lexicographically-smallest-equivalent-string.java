class Solution {
    
    class Node {
        char c;
        Node parent;
    }
    
    private Node findParent(Node node){
        if(node != node.parent){
            node.parent = findParent(node.parent);
        }
        return node.parent;
    }
    
    private void link(Node node1, Node node2){
        
        node1 = findParent(node1);
        node2 = findParent(node2);
        
        if(node1 == node2){
            return;
        }
        
        if(node1.c < node2.c){
            node2.parent = node1;
        } else {
            node1.parent = node2;
        }
        
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        Map<Character, Node> nodeMap = new HashMap<>();
        
        for(int index = 0; index < s1.length(); index++){
            char c1 = s1.charAt(index);
            char c2 = s2.charAt(index);
            Node node1 = new Node();
            node1.c = c1;
            node1.parent = node1;
            Node node2 = new Node();
            node2.c = c2;
            node2.parent = node2;
            nodeMap.put(c1, node1);
            nodeMap.put(c2, node2);
            link(node1, node2);
        }
        
        for(int index = 0; index < s1.length(); index++){
            char c1 = s1.charAt(index);
            char c2 = s2.charAt(index);
            Node node1 = nodeMap.get(c1);
            Node node2 = nodeMap.get(c2);
            link(node1, node2);
        }
        
        StringBuilder builder = new StringBuilder();
        
        for(int index = 0; index < baseStr.length(); index++){
            char c = baseStr.charAt(index);
            if(nodeMap.containsKey(c)){
               builder.append(findParent(nodeMap.get(c)).c);
            } else {
                builder.append(c);
            }
        }
        
        return builder.toString();
    }
}