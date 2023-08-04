class Solution {
    
    public int findJudge(int n, int[][] trust) {
        
        Map<Integer, List<Integer>> trusteeMap = new HashMap<>();
        Map<Integer, List<Integer>> trustedMap = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            trusteeMap.put(i, new ArrayList<>());
            trustedMap.put(i, new ArrayList<>());
        }
        
        for(int [] trusts: trust){
            int trustee = trusts[0], trusted = trusts[1];
            List<Integer> lst1 = trusteeMap.getOrDefault(trustee, new ArrayList<>());
            lst1.add(trusted);
            List<Integer> lst2 = trustedMap.getOrDefault(trusted, new ArrayList<>());
            lst2.add(trustee);
            trusteeMap.put(trustee, lst1);
            trustedMap.put(trusted, lst2);
        }
        
        int judge = -1;
        
        for(Map.Entry<Integer, List<Integer>> entry: trusteeMap.entrySet()){
            if(entry.getValue().size() == 0){
                judge = entry.getKey();
            }
        }
        
        if(judge == -1) return -1;
        
        if(trustedMap.get(judge).size() == n - 1) return judge;
        
        return -1;
    }
    
}