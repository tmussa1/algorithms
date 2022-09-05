class Twitter {

    Map<Integer, TreeSet<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followerMap;
    
    int timestamp, MAX_TWEET_SIZE = 10;
    
    public Twitter() {
        this.timestamp = 0;
        this.tweetMap = new HashMap<>();
        this.followerMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        
        TreeSet<Tweet> tweets = tweetMap.getOrDefault(userId, new TreeSet<Tweet>((a, b) -> b.timestamp - a.timestamp));
        tweets.add(new Tweet(tweetId, this.timestamp++));
        tweetMap.put(userId, tweets);
        
        Set<Integer> followees = followerMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);
        followerMap.put(userId, followees);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer> result = new ArrayList<>();
        
        if(!followerMap.containsKey(userId)) return result;
        
        Set<Integer> followees = followerMap.get(userId);
        
        PriorityQueue<Tweet> tweetsQueue = new PriorityQueue<Tweet>((a, b) -> b.timestamp - a.timestamp);
        
        for(Integer followee: followees){
            
            if(tweetMap.containsKey(followee)){
                
                TreeSet<Tweet> tweets = tweetMap.get(followee);
                tweetsQueue.addAll(tweets);
                
                // while(tweetsQueue.size() > MAX_TWEET_SIZE){
                //     tweetsQueue.poll();
                // }
            }
        }
        
        while(!tweetsQueue.isEmpty() && result.size() < MAX_TWEET_SIZE){
            result.add(tweetsQueue.poll().tweetId);
        }
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = followerMap.getOrDefault(followerId, new HashSet<>());
        followees.add(followeeId);
        followerMap.put(followerId, followees); 
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if(followerMap.containsKey(followerId)){
           Set<Integer> followees = followerMap.get(followerId);
           followees.remove(followeeId);
           followerMap.put(followerId, followees); 
        }
    }
    
    class Tweet {
        
        int tweetId;
        int timestamp;
        
        public Tweet(int tweetId, int timestamp){
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */