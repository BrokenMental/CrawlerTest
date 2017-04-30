package test4;

import java.util.List;

import twitter4j.*;

public class twitter4j_test3{
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args search query
     */
    public static void main(String[] args) {
    	Twitter twitter = TwitterFactory.getSingleton();
        try {
            Query query = new Query("단어"); // Query에 빈칸을 넣게되면 오류가 발생, 트위터에서 공백검색을 막아서 그런것 같다.
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
}
