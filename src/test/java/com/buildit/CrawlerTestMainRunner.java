package com.buildit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CrawlerTestMainRunner {

    @Test
    void testWebCrawler() {
        Crawler crawler = new Crawler();
        String url = "http://news.yahoo.com/";
        String hostName = url.split("/")[2];

        int numberOfPagesVisited = crawler.crawl(1, url, new ArrayList<String>(), hostName);
        Assertions.assertEquals(10, numberOfPagesVisited);
    }
}