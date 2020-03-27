package com.demo.webcrawler.service.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.demo.webcrawler.dto.CrawledResponse;
import com.demo.webcrawler.dto.PageDetail;
import com.demo.webcrawler.service.CrawlerService;

@Service
public class CrawlerServiceImpl implements CrawlerService {

	private static final Logger LOGGER = LogManager.getLogger(CrawlerServiceImpl.class);

	private CrawledResponse pageDetailResponse;

	@Override
	public CrawledResponse deepCrawl(final String url, final int depth) {
		pageDetailResponse = new CrawledResponse();
		crawl(url, depth);
		pageDetailResponse.setTotalLinks(pageDetailResponse.getPageDetails().size());
		return pageDetailResponse;
	}

	private void crawl(final String url, int depth) {
		LOGGER.info("Starting crawler for url {} for depth {}", url, depth);
		if (depth > 0 && !pageDetailResponse.getPageDetails().contains(new PageDetail(url)))
			try {
				Document document = Jsoup.connect(url).get();
				Elements linksOnPage = document.select("a[href]");
				String title = document.title();
				int imageCount = document.select("img").size();
				PageDetail detail = new PageDetail(title, url, imageCount);
				pageDetailResponse.getPageDetails().add(detail);
				for (Element page : linksOnPage)
					crawl(page.attr("abs:href"), --depth);
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
	}
}
