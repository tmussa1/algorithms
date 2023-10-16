class Solution {
    
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int [] startTimes = new int[flowers.length];
        int [] endTimes = new int[flowers.length];
        
        for(int i = 0; i < flowers.length; i++){
            startTimes[i] = flowers[i][0];
            endTimes[i] = flowers[i][1];
        }
        
        int [] [] people2 = new int [people.length][2];
        
        for(int i = 0; i < people.length; i++){
             people2[i][0] = people[i];
             people2[i][1] = i;
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        Arrays.sort(people2, (a, b) -> a[0] - b[0]);
        
        int [] result = new int[people.length];
        
        int startIndex = 0, endIndex = 0, count = 0, peopleIndex = 0;
        
        while(peopleIndex < people.length){
            
            int person = people2[peopleIndex][0];
            
            while(startIndex < flowers.length && person >= startTimes[startIndex]){
                count++;
                startIndex++;
            }
            
            while(endIndex < flowers.length && person > endTimes[endIndex]){
                count--;
                endIndex++;
            }
            
            result[people2[peopleIndex][1]] = count;
            peopleIndex++;
        }
        
        return result;
    }
}