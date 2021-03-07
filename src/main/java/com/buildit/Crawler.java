package com.buildit;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;

public class Crawler {

    private final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    private final int MAX_PAGES_TO_SEARCH = 10;

    public int crawl(int level, String url, ArrayList<String> visited, String hostName) {
        while(visited.size() < MAX_PAGES_TO_SEARCH) {
            Document doc = request(url, visited);

            if (doc != null) {
                for(Element link : doc.select("a[href]")) {
                    String next_link = link.absUrl("href");

                    String nextLinkHostName = next_link.split("/")[2];
                    if(nextLinkHostName.contains(hostName) && visited.contains(next_link) == false) {
                        crawl(level++, next_link, visited, hostName);
                    }
                }
            }
        }

        return visited.size();
    }

    private Document request(String url, ArrayList<String> v) {
        try {
            Connection con = Jsoup.connect(url).userAgent(USER_AGENT);

            Document doc = con.get();

            if (con.response().statusCode() == 200) {
                System.out.println("Link: " + url);
                System.out.println(doc.title());
                v.add(url);

                return doc;
            }

            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
