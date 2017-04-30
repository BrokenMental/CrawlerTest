package test3;

import java.io.IOException;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoup_Test2 {
	public static void main(String args[]) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo");
		try {
			httpClient.execute(httpget, new BasicResponseHandler() {
				@Override
				public String handleResponse(HttpResponse response) throws HttpResponseException, IOException {
					String res = new String(super.handleResponse(response).getBytes("8859_1"), "UTF-8");
					Document doc = Jsoup.parse(res);
					Elements rows = doc.select("div.tbl_box tbody tr");
					String[] items = new String[] { "ÆÀ", "°æ±â¼ö", "½Â", "ÆÐ", "¹«", "½Â·ü", "¿¬¼Ó", "ÃÖ±Ù 10°æ±â" };
					for (Element row : rows) {
						Iterator<Element> iterElem = row.getElementsByTag("td").iterator();
						StringBuilder builder = new StringBuilder();
						for (String item : items) {
							builder.append(item + ": " + iterElem.next().text() + "    \t");
						}
						System.out.println(builder.toString());
					}

					return res;
				}
			});
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
