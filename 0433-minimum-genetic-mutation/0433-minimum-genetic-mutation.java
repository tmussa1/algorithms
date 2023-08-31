class Solution {
    
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);
        
        if(!bankSet.contains(endGene)) return -1;
        
        char [] validChars = {'A', 'C', 'G', 'T'};
        
        Set<Integer> differenceIndices = new HashSet<>();
        
        for(int i = 0; i < startGene.length(); i++){
            char start = startGene.charAt(i), end = endGene.charAt(i);
            if(start != end){
                differenceIndices.add(i);
            }
        }
        
        System.out.println(differenceIndices);
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        
        Set<String> seen = new HashSet<>();
        seen.add(startGene);
        
        int level = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                String curr = queue.poll();
                System.out.println(curr);
                seen.add(curr);
                
                if(curr.equals(endGene)) return level;
                
                char[] currArr = curr.toCharArray();
                
                for (int j = 0; j < currArr.length; j++) {
                    char originalChar = currArr[j];
                    for (char c : validChars) {
                        currArr[j] = c;
                        String newGene = new String(currArr);
                        
                        if (bankSet.contains(newGene) && !seen.contains(newGene)) {
                            queue.offer(newGene);
                            seen.add(newGene);
                        }
                    }
                    currArr[j] = originalChar;
                }
            }
            
            level++;
        }
        
        return -1;
    }
}