package com.demo.webcrawler.service;

import com.demo.webcrawler.dto.CrawledResponse;

public interface CrawlerService {

	CrawledResponse deepCrawl(String url, int depth);

}
