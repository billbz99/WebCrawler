package com.buildit;

import java.util.ArrayList;

public class CrawlerMainRunner {
    public static void main(String[] args) {

        Crawler crawler = new Crawler();

        String url = "http://news.yahoo.com/";
        String hostName = url.split("/")[2];

        int numberOfPagesVisited = crawler.crawl(1, url, new ArrayList<String>(), hostName);
        System.out.println(String.format("**Done** Visited %s web page(s)", numberOfPagesVisited));
    }
}
