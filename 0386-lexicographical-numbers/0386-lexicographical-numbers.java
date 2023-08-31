class Solution {
    public List<Integer> lexicalOrder(int n) {
        
        List<String> result = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            result.add(i + "");
        }
        
        Collections.sort(result);
        
        return result.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}