class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Node, List<Node>> adjList = constructAdjList(times);
        
        Node node = findNode(adjList, k);
        
        Map<String, Integer> weightMap = mapWeight(times);
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        int nodesVisited = 1;
        Set<Node> visited = new HashSet<>();
        visited.add(node);
        
        List<Integer> distances = new ArrayList<>();
        
        while(!queue.isEmpty()){
            
            Node curr = queue.poll();
            
            if(adjList.get(curr) != null && adjList.get(curr).size() > 0){
                for(Node adjNode: adjList.get(curr)){
                    
                    int newDistance = weightMap.get(curr.val + "," + adjNode.val) + curr.distance;
                    
                    if(!visited.contains(adjNode) || newDistance < adjNode.distance){
                        
                        if(newDistance < adjNode.distance){
                            for(int i = 0; i < distances.size(); i++){
                                if(distances.get(i) == adjNode.distance){
                                    distances.remove(i);
                                    break;
                                }
                            }
                        }
                        
                        adjNode.distance = adjNode.distance > 0 ? Math.min(adjNode.distance, newDistance) : newDistance;
                        distances.add(adjNode.distance);
                        queue.offer(adjNode); 
                        nodesVisited = !visited.contains(adjNode) ? nodesVisited + 1 : nodesVisited;
                        visited.add(adjNode);
                    }
                }
            }
        }
        
        int maxDistance = distances.stream().mapToInt(a -> a).max().orElse(-1);
        
        return nodesVisited == n ? maxDistance : -1;
    }
    
    
    Node findNode(Map<Node, List<Node>> adjList, int k){
        
        Node result = null;
        
        for(Node node: adjList.keySet()){
            if(node.val == k){
                result = node;
            }
        }
        
        return result;
    }
    
    Map<String, Integer> mapWeight(int[][] times){
        
        Map<String, Integer> weightMap = new HashMap<>();
        
        for(int i = 0; i < times.length; i++){
            weightMap.put(times[i][0] + "," + times[i][1], times[i][2]);
        }
        
        return weightMap;
    }
    
    Map<Node, List<Node>> constructAdjList(int[][] times){
        
        Map<Node, List<Node>> adjList = new HashMap<>();
        Map<Integer, Node> nodes = new HashMap<>();
        
        for(int i = 0; i < times.length; i++){
            
            Node node = nodes.getOrDefault(times[i][0], new Node(times[i][0]));
            List<Node> lst = adjList.getOrDefault(node, new ArrayList<>());
            
            Node adjNode = nodes.getOrDefault(times[i][1], new Node(times[i][1]));
            lst.add(adjNode);
            
            adjList.put(node, lst);
            nodes.put(times[i][0], node);
            nodes.put(times[i][1], adjNode);
        }
        
        return adjList;
    }
    
    class Node {
        
        int val;
        int distance;
        
        Node(int val){
            this.val = val;
            this.distance = 0;
        }
    }
}