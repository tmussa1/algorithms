class Solution {
    
    class Node {
        String val;
        int rank;
        Node parent;
    }
    
    Node findNode(Node node){
        if(node != node.parent){
            node.parent = findNode(node.parent);
        }
        return node.parent;
    }
    
    private void link(Node node1, Node node2){
        
        node1 = findNode(node1);
        node2 = findNode(node2);
        
        if(node1 == node2){
            return;
        }
        
        if(node1.rank > node2.rank){
            node2.parent = node1;
        } else if(node2.rank > node1.rank){
            node1.parent = node2;
        } else {
            node1.rank += 1;
            node2.parent = node1;
        }
    }
    
    public boolean equationsPossible(String[] equations) {
        
        Map<String, Node> nodeMap = new HashMap<>();
        
        Set<String> values = new HashSet<>();
        
        for(String equation: equations){
            
            String [] split = equation.split("==");
            
            if(split.length > 1){
                values.add(split[0]);
                values.add(split[1]);  
            }
            
            String [] split2 = equation.split("!=");
            
            if(split2.length > 1){
                values.add(split2[0]);
                values.add(split2[1]);  
            }
        }
        
        for(String value: values){
            Node node1 = new Node();
            node1.val = value;
            node1.parent = node1;
            nodeMap.put(value, node1);
        }
        
                
         for(String equation: equations){
            
             String [] split = equation.split("==");
             
             if(split.length > 1){
                 
                Node node1 = nodeMap.get(split[0]);
                Node node2 = nodeMap.get(split[1]);
                
                link(node1, node2);
             }
         }
        
         for(String equation: equations){
            
             String [] split2 = equation.split("!=");
            
             if(split2.length > 1){
                 
                Node node1 = nodeMap.get(split2[0]);
                Node node2 = nodeMap.get(split2[1]);
                 
                node1 = findNode(node1);
                node2 = findNode(node2);
                 
                if(node1 == node2){
                    return false;
                }
             }
         }
        
        
         return true;
    }
}