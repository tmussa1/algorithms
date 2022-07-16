class Solution {
    
    private int link(Node node1, Node node2){
        
        Node node1Parent = find(node1);
        Node node2Parent = find(node2);
        
        if(node1Parent == node2Parent){
            return 0;
        }
        
        if(node1Parent.rank > node2Parent.rank){
            node2Parent.parent = node1.parent;
        } else if(node2Parent.rank > node1Parent.rank){
            node1Parent.parent = node2.parent;
        } else {
            node1Parent.parent = node2.parent;
            node1Parent.rank += 1;
        }
        
        return 1;
    }
    
    private Node find(Node node){
        
        if(node != node.parent){
            node.parent = find(node.parent);
        }
        
        return node.parent;
    }
    
    public int removeStones(int[][] stones) {
        
        int removed = 0;
        
        Map<Integer, List<Node>> rowMap = new HashMap<>();
        Map<Integer, List<Node>> columnMap = new HashMap<>();
        
        for(int i = 0; i < stones.length; i++){
            
            int row = stones[i][0], col = stones[i][1];
            
            List<Node> rowList = rowMap.getOrDefault(row, new ArrayList<>());
            List<Node> colList = columnMap.getOrDefault(col, new ArrayList<>());
            
            Node node = new Node();
            node.x = row;
            node.y = col;
            node.rank = 0;
            node.parent = node;
            
            rowList.add(node);
            colList.add(node);
            
            rowMap.put(row, rowList);
            columnMap.put(col, colList);
        }
        
        for(Map.Entry<Integer, List<Node>> entries: rowMap.entrySet()){
            List<Node> rows = entries.getValue();
            
            for(int i = 0; i < rows.size() - 1; i++){
                Node node1 = rows.get(i), node2 = rows.get(i + 1);
                removed += link(node1, node2);
            }
        }
        
        for(Map.Entry<Integer, List<Node>> entries: columnMap.entrySet()){
            List<Node> cols = entries.getValue();
            
            for(int i = 0; i < cols.size() - 1; i++){
                Node node1 = cols.get(i), node2 = cols.get(i + 1);
                removed += link(node1, node2);
            }
        }
        
        return removed;
    }
    
    class Node {
        int x, y;
        int rank;
        Node parent;
    }
}