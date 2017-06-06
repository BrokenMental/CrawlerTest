package test3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoup_Test1 {
	public static void main(String[] args) throws Exception{
		String URL = "https://news.google.co.kr";
		Document doc = Jsoup.connect(URL).get();
		Elements el = doc.select("div.esc-default-layout-wrapper");
		
		for(Element Temp: el){
			//System.out.println(Temp.text());
			if(Temp.select("div.esc-thumbnail-image-wrapper img").attr("src").equals("")){
				System.out.println("imgsrc : " +Temp.select("div.esc-thumbnail-image-wrapper img").attr("imgsrc"));
			}else{
				System.out.println("img : " +Temp.select("div.esc-thumbnail-image-wrapper img").attr("src"));
			}
			System.out.println("group : " +Temp.select("span.al-attribution-source").text());
			System.out.println("name : " +Temp.select("div.esc-lead-article-title-wrapper a").text());
			System.out.println("addr : " +Temp.select("div.esc-lead-article-title-wrapper a").attr("href"));
			System.out.println("----------------------------------------------------------------------------");
		}
	}
}