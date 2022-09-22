class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> intersections = new ArrayList<>();
        
        int firstPtr = 0, secondPtr = 0;
        
        while(firstPtr < firstList.length && secondPtr < secondList.length){
            
            int [] first = firstList[firstPtr];
            int [] second = secondList[secondPtr];
            
            if(first[0] <= second[1] && second[0] <= first[0]){
                int [] intersection = new int [] {first[0], Math.min(first[1], second[1])};
                intersections.add(intersection);
            } else if(second[0] <= first[1] && first[0] <= second[0]){
                int [] intersection = new int [] {second[0], Math.min(first[1], second[1])};
                intersections.add(intersection);
            } 
            
            if(second[1] < first[1]){
                secondPtr++;
            } else {
                firstPtr++;
            }
        }
        
        int [] [] result = new int [intersections.size()][2];
        int count = 0;
        
        for(int [] intersection: intersections){
            result[count++] = intersection;
        }
        
        return result;
    }
}