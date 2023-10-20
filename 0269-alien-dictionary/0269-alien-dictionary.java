class Solution {
    public String alienOrder(String[] words) {

        boolean [] flag = new boolean[1];
        Map<Character, List<Character>> adjList = constructAdjList(words, flag);

        if(flag[0]) return "";

        Set<Character> visited = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for(Character node: adjList.keySet()){
            if(!dfs(adjList, node, visited, new HashSet<>(), builder)){
                return "";
            }
        }

        return builder.reverse().toString();
    }

    private boolean dfs(Map<Character, List<Character>> adjList, Character node, Set<Character> visited, Set<Character> cycle, StringBuilder builder){

        if(cycle.contains(node)){
            return false;
        }

        if(visited.contains(node)){
            return true;
        }

        visited.add(node);
        cycle.add(node);

        for(Character neighbor: adjList.get(node)){
            if(!dfs(adjList, neighbor, visited, cycle, builder)){
                return false;
            }
        }

        cycle.remove(node);
        builder.append(node);

        return true;
    }

    private Map<Character, List<Character>> constructAdjList(String[] words, boolean [] flag){

        Map<Character, List<Character>> adjList = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i], word2 = words[i + 1];
            int j = 0;
            while(j < Math.min(word1.length(), word2.length()) && word1.charAt(j) == word2.charAt(j)){
                j++;
            }

            if(j == word2.length() && j < word1.length()){
                flag[0] = true;
            }

            if(j == word2.length() || j == word1.length()){
                continue;
            }

            List<Character> lst = adjList.getOrDefault(word1.charAt(j), new ArrayList<>());
            lst.add(word2.charAt(j));
            adjList.put(word1.charAt(j), lst);
        }

        return adjList;
    }
}