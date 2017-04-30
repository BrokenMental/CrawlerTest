package test4;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class twitter4j_test1 {
	public static void main(String args[]) {
	    try {
	    	/* properties 작성으로 인해 따로 토큰을 넣어줄 필요가 없음
	        AccessToken accesstoken = new AccessToken("3003358656-WqT8y0oososXBnTVW938RXtk6ThBnC0pJLGG2Lh", "1FNVn9uq1iF5S7DwETltByJER1mqP8s38oumNeuSelY5z"); // 1.Access Token, 2.Access Token Secret
	        Twitter twitter = TwitterFactory.getSingleton();
	        twitter.setOAuthConsumer("8XrTEGZ9AQtLdn7Aur17R692V", "HDxYaiwVQ5FcLBKj7PAfPoHM98rDhZsrHVh1DJWpkgyx7jC8z5"); // 1. Consumer Key (API Key), 2.Consumer Secret (API Secret)
	        twitter.setOAuthAccessToken(accesstoken);
	        */
	        Twitter twitter = TwitterFactory.getSingleton();
	        User user = twitter.verifyCredentials();
	         
	        List<Status> list = twitter.getHomeTimeline();
	        System.out.println("타임라인 계정:"+user.getScreenName());
	        for(Status status : list) {
	            System.out.println("작성자:"+status.getUser().getScreenName());
	            System.out.println("타임라인내용:"+status.getText());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
