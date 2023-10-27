class Solution {
    
    public int findMinArrowShots(int[][] points) {
        
        long prevEnd = Long.MAX_VALUE;
        int result = 1;
        
        long [][] pointArray = Arrays.stream(points)
            .map(row -> Arrays.stream(row)
                .mapToLong(value -> (long) value)
                .toArray()
            )
            .toArray(long[][]::new);
        
        Arrays.sort(pointArray, (a, b) -> {
            
            if(a[0] == b[0]){
                return Long.compare(a[1], b[1]);
            }
            
            return Long.compare(a[0], b[0]);
        });
        
        for(long [] point: pointArray) {
            if(point[0] < prevEnd){
                prevEnd = Math.min(prevEnd, point[1]);
            } else if(point[0] > prevEnd){
                result++;
                prevEnd = point[1];
            }
        }
        
        return result;
    }
}