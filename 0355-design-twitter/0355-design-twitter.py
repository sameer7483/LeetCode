class Node:
    def __init__(self, userId, tweets, following):
        self.userId = userId
        self.tweets = tweets
        self.following = following
class Twitter:

    def __init__(self):
        self.m = dict()
        self.time = 0
        
    def postTweet(self, userId: int, tweetId: int) -> None:
        self.time += 1
        if userId in self.m:
            self.m[userId].tweets.append((tweetId, self.time))
        else:
            self.m[userId] = Node(userId, [(tweetId, self.time)], set([userId]))

    def getNewsFeed(self, userId: int) -> List[int]:
        if userId not in self.m:
            self.m[userId] = Node(userId, [], set([userId]))
            return []
        user = self.m[userId]
        allTweets =[]
        # allTweets = [tweet for friend in user.following for tweet in self.m[friend].tweets if friend in self.m]
        for friend in user.following:
            if friend in self.m:
                for tweet in self.m[friend].tweets:
                    allTweets.append(tweet)
        # print(allTweets)
        return map(lambda y : y[0], sorted(allTweets,key = lambda x: x[1], reverse=True)[:10])

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.m:
            self.m[followerId].following.add(followeeId)
        else:
            self.m[followerId] = Node(followerId, [], set([followeeId, followerId]))        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.m:
            self.m[followerId].following.discard(followeeId)         


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)