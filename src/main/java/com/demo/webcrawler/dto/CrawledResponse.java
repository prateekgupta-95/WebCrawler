package com.demo.webcrawler.dto;

import java.util.HashSet;
import java.util.Set;

public class CrawledResponse {

	private int totalLinks;
	private Set<PageDetail> pageDetails = new HashSet<>();
	private int totalImages;

	/**
	 * @return the totalLinks
	 */
	public int getTotalLinks() {
		return totalLinks;
	}

	/**
	 * @param totalLinks the totalLinks to set
	 */
	public void setTotalLinks(final int totalLinks) {
		this.totalLinks = totalLinks;
	}

	/**
	 * @return the pageDetails
	 */
	public Set<PageDetail> getPageDetails() {
		return pageDetails;
	}

	/**
	 * @param pageDetails the pageDetails to set
	 */
	public void setPageDetails(final Set<PageDetail> pageDetails) {
		this.pageDetails = pageDetails;
	}

	/**
	 * @return the totalImages
	 */
	public int getTotalImages() {
		return totalImages;
	}

	/**
	 * @param totalImages the totalImages to set
	 */
	public void setTotalImages(final int totalImages) {
		this.totalImages = totalImages;
	}

}
