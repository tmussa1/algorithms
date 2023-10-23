class Solution {
    
    public boolean canReach(int[] arr, int start) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        Set<Integer> visited = new HashSet<>();
        
        while(!queue.isEmpty()){
            
            int curr = queue.poll();
            visited.add(curr);
            
            if(arr[curr] == 0) return true;
            
            int left = curr - arr[curr];
            
            if(left >= 0 && !visited.contains(left)){
                queue.offer(left);
            }
            
            int right = curr + arr[curr];
            
            if(right < arr.length && !visited.contains(right)){
                queue.offer(right);
            }
        }
        
        return false;
    }
}