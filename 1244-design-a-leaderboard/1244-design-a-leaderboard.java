class Leaderboard {
    
    Map<Integer, Integer> playerScore;
    TreeMap<Integer, Set<Integer>> scorePlayer;
    
    public Leaderboard() {
        this.playerScore = new HashMap<>();
        this.scorePlayer = new TreeMap<>((a, b) -> b - a);
    }
    
    public void addScore(int playerId, int newScore) {
        
        if(this.playerScore.containsKey(playerId)) {
            int score = this.playerScore.get(playerId);
            newScore += score;
            Set<Integer> player = this.scorePlayer.get(score);
            player.remove(playerId);
            this.scorePlayer.put(score, player);
            this.playerScore.put(playerId, newScore);
            Set<Integer> players = this.scorePlayer.getOrDefault(newScore, new HashSet<>());
            players.add(playerId);
            this.scorePlayer.put(newScore, players);
        } else {
            Set<Integer> players = this.scorePlayer.getOrDefault(newScore, new HashSet<>());
            players.add(playerId);
            this.scorePlayer.put(newScore, players);
            this.playerScore.put(playerId, newScore);
        }
    }
    
    public int top(int K) {
        
        int sum = 0, count = K;
        
        Iterator<Map.Entry<Integer, Set<Integer>>> iterator = this.scorePlayer.entrySet().iterator();
        
        Map.Entry<Integer, Set<Integer>> entry = null;
        
        while(iterator.hasNext() && count > 0){
            
            entry = iterator.next();
            
            int size = Math.min(entry.getValue().size(), count);
            
            sum += (entry.getKey() * size);
            
            count -= size;
        }
        
        return sum;
    }
    
    public void reset(int playerId) {
        int score = this.playerScore.get(playerId);
        Set<Integer> player = this.scorePlayer.get(score);
        player.remove(playerId);
        this.scorePlayer.put(score, player);
        this.playerScore.put(playerId, 0);
        Set<Integer> players = this.scorePlayer.getOrDefault(0, new HashSet<>());
        players.add(playerId);
        this.scorePlayer.put(0, players);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */