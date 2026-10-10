class Twitter {
    HashMap<Integer,PriorityQueue<Integer>> userToPost;
    HashMap<Integer,Integer> tweetToTime;
    HashMap<Integer,HashSet<Integer>> followerToFollowee;
    int time;

    public Twitter() {
        userToPost=new HashMap<>();
        tweetToTime=new HashMap<>();
        time=0;
        followerToFollowee=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        tweetToTime.put(tweetId, time);
        if(userToPost.containsKey(userId)){
        }else{
            userToPost.put(userId,new PriorityQueue<>((a,b)->Integer.compare(tweetToTime.get(b),tweetToTime.get(a))));
        }
        userToPost.get(userId).offer(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans=new ArrayList<>();

        int count=0;
        PriorityQueue<Integer> temp = new PriorityQueue<>((a,b) -> Integer.compare(tweetToTime.get(b), tweetToTime.get(a)));
        if (userToPost.containsKey(userId)) {
            temp.addAll(userToPost.get(userId));
        }
        if (followerToFollowee.containsKey(userId)) {
            for (Integer followeeId : followerToFollowee.get(userId)) {
                if (userToPost.containsKey(followeeId)) {
                    temp.addAll(userToPost.get(followeeId));
                }
            }
        }
        while(count<10  && !temp.isEmpty()){
            ans.add(temp.poll());
            count++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followerToFollowee.containsKey(followerId)){
            followerToFollowee.put(followerId,new HashSet<>());
        }
        followerToFollowee.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followerToFollowee.containsKey(followerId)) return;
        if(followerToFollowee.get(followerId).contains(followeeId)){
            followerToFollowee.get(followerId).remove(followeeId);
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