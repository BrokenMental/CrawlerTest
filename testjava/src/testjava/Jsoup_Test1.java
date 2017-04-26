package testjava;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoup_Test1 {
	public static void main(String[] args) throws Exception{
		String URL = "https://news.google.co.kr";
		Document doc = Jsoup.connect(URL).get();
		Elements el0 = doc.select("div.esc-lead-article-title-wrapper");
		Elements el1 = doc.select("div.esc-lead-article-title-wrapper span.titletext");
		Elements el2 = doc.select("div.esc-lead-article-title-wrapper a");
		Elements el3 = doc.select("div.section-stream-content");
		Elements el4 = doc.select("div.section-list");
		Elements el5 = doc.select("div.esc-lead-article-title-wrapper id.MAA4AEgCUABgAWoCa3I"); // 안됌
		Elements el6 = doc.select("table.esc-layout-table tbody tr td.esc-layout-article-cell a"); // 링크 안뜸
		
		for(Element Temp: el2){
			//System.out.println(Temp.text());
			System.out.println("제목 : " +Temp.text());
			System.out.println("링크 : " +Temp.attr("href"));
		}
	}
}
