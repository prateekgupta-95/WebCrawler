package com.demo.webcrawler.controller;

import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webcrawler.dto.CrawledResponse;
import com.demo.webcrawler.service.CrawlerService;

@RestController
public class WebCrawlerController {

	@Resource
	private CrawlerService crawlerService;

	private static final Logger LOGGER = LogManager.getLogger(WebCrawlerController.class);

	public static final int DEFAULT_DEPTH = 2;

	@GetMapping(value = "/crawler")
	public ResponseEntity<CrawledResponse> getWebPageTreeInfo(
			@NotNull @RequestParam(value = "url", required = true) final String url,
			@RequestParam(value = "depth", required = false) final Integer depth) {

		LOGGER.info("Request for deep crawling received for url: {}, depth: {}", url, depth);
		final int newDepth = Optional.ofNullable(depth).orElse(DEFAULT_DEPTH);
		LOGGER.info("Depth might be optimized to go upto Max -{}", newDepth);
		return new ResponseEntity<>(crawlerService.deepCrawl(url, depth), HttpStatus.OK);
	}

}
