class Solution {
    
    private void link(Node node1, Node node2){
        
        Node node1Parent = find(node1);
        Node node2Parent = find(node2);
        
        if(node1Parent == node2Parent){
            return;
        }
        
        if(node1Parent.rank > node2Parent.rank){
            node2Parent.parent = node1Parent;
            node1Parent.emails.addAll(node2Parent.emails);
        } else if(node2Parent.rank > node1Parent.rank){
            node1Parent.parent = node2Parent;
            node2Parent.emails.addAll(node1Parent.emails);
        } else {
            node2Parent.parent = node1Parent;
            node1Parent.rank += 1;
            node1Parent.emails.addAll(node2Parent.emails);
        }
    }
    
    private Node find(Node node){
        
        if(node.parent != node){
            node = find(node.parent);
        }
        
        return node;
    }
    
    private Node [] makeSet(List<List<String>> accounts){
        
        Node [] nodes = new Node[accounts.size()];
        
        for(int i = 0; i < accounts.size(); i++){
            nodes[i] = new Node(accounts.get(i).get(0));
            nodes[i].rank = 1;
            nodes[i].index = i;
            nodes[i].parent = nodes[i];
            nodes[i].emails = new HashSet<>(accounts.get(i).subList(1, accounts.get(i).size()));
        }
        
        return nodes;
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Node [] nodes = makeSet(accounts);
        
        Map<String, List<Integer>> emailToIdxMap = new HashMap<>();
        
        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String currEmail = accounts.get(i).get(j);
                List<Integer> lst = emailToIdxMap.getOrDefault(currEmail, new ArrayList<>());
                lst.add(i);
                emailToIdxMap.put(currEmail, lst);
            }
        }
        
        System.out.println(emailToIdxMap);
        
        List<List<String>> result = new ArrayList<>();
        
        for(Map.Entry<String, List<Integer>> entry: emailToIdxMap.entrySet()){
            
            for(int i = 0; i < entry.getValue().size() - 1; i++){
                Node node1 = nodes[entry.getValue().get(i)];
                Node node2 = nodes[entry.getValue().get(i + 1)];
                link(node1, node2);
            }
        }
        
        for(Node node: nodes){
            System.out.print(node.index + " ");
            System.out.println(node.emails);
            if(node == node.parent){
                LinkedList<String> emails = new LinkedList<>(node.emails);
                Collections.sort(emails);
                emails.addFirst(node.name);
                result.add(emails);
            }
        }
        
        return result;
    }
    
    class Node {
        
        String name;
        int rank;
        int index;
        Set<String> emails;
        Node parent;
        
        Node(String name){
            this.name = name;
            this.emails = new HashSet<>();
        }
    }
}