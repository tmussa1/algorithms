class Solution {
    
    public int[] getOrder(int[][] tasks) {
        
        int [] result = new int[tasks.length];
        
        int[][] tasksSorted = new int[tasks.length][3];
        
        for(int i = 0; i < tasks.length; i++){
            tasksSorted[i][0] = tasks[i][0];
            tasksSorted[i][1] = tasks[i][1];
            tasksSorted[i][2] = i;
        }
        
        PriorityQueue<int []> queue = new PriorityQueue<int []>((a, b) -> {
            if(a[1] == b[1]){
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });
        
        Arrays.sort(tasksSorted, (a, b) -> {
            return a[0] - b[0];
        });
        
        int index = 0, taskIndex = 0;
        long time = 0;
        
        while(taskIndex < tasks.length || !queue.isEmpty()){ 
            
            while(taskIndex < tasks.length && time >= tasksSorted[taskIndex][0]){
                 int [] pair1 = tasksSorted[taskIndex];
                 queue.offer(pair1);
                 taskIndex++;
            }
            
            if(queue.isEmpty()){
                time = tasksSorted[taskIndex][0];
            } else {
                int [] curr = queue.poll();
                time += curr[1];
                result[index++] = curr[2];
            }
        }
        
        return result;
    }
}