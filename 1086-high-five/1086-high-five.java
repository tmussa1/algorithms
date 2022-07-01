class Solution {
    
    public int[][] highFive(int[][] items) {
        
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            
            return b[0] - a[0];
        });
        
        for(int i = 0; i < items.length; i++){
            queue.offer(items[i]);
        }
        
        int topFive = 1;
        
        List<int []> result = new ArrayList<>();
        
        while(!queue.isEmpty()){
            
            int [] top = queue.poll();
            int index = top[0];
            
            int sum = top[1];
            
            while(!queue.isEmpty() && queue.peek()[0] == index && topFive < 5){
                sum += queue.poll()[1];
                topFive++;
            }
            
            sum = sum / topFive;
            
            result.add(new int[] {index, sum});
            
            topFive = 1;
            
            while(!queue.isEmpty() && queue.peek()[0] == index) {
                queue.poll();
            }
        }
        
        int [] [] resultArray = new int[result.size()][2];
        
        for(int i = 0; i < result.size(); i++){
            resultArray[i][0] = result.get(i)[0];
            resultArray[i][1] = result.get(i)[1];
        }
        
        Arrays.sort(resultArray, (a, b) -> a[0] - b[0]);
        
        return resultArray;
    }
}