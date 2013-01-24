package ir.assignments.three;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;

public class Test {
	public static void main(String[] args){
		WebURL url = new WebURL();
		url.setURL("http://www.ics.uci.edu/");
		Page page = new Page(url);
		Crawler crawler = new Crawler();
		crawler.visit(page);
	}
}
