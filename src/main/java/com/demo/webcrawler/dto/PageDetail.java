package com.demo.webcrawler.dto;

public class PageDetail {

	public PageDetail(final String pageTitle, final String pageLink, final int imageCount) {
		super();
		this.pageTitle = pageTitle;
		this.pageLink = pageLink;
		this.imageCount = imageCount;
	}

	private String pageTitle;
	private String pageLink;
	private int imageCount;

	public PageDetail(final String pageTitle, final String pageLink) {
		this.pageTitle = pageTitle;
		this.pageLink = pageLink;
	}

	public PageDetail(final String pageLink) {
		this.pageLink = pageLink;
	}

	/**
	 * @return the pageTitle
	 */
	public String getPageTitle() {
		return pageTitle;
	}

	/**
	 * @param pageTitle the pageTitle to set
	 */
	public void setPageTitle(final String pageTitle) {
		this.pageTitle = pageTitle;
	}

	/**
	 * @return the pageLink
	 */
	public String getPageLink() {
		return pageLink;
	}

	/**
	 * @param pageLink the pageLink to set
	 */
	public void setPageLink(final String pageLink) {
		this.pageLink = pageLink;
	}

	/**
	 * @return the imageCount
	 */
	public int getImageCount() {
		return imageCount;
	}

	/**
	 * @param imageCount the imageCount to set
	 */
	public void setImageCount(final int imageCount) {
		this.imageCount = imageCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (pageLink == null ? 0 : pageLink.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageDetail other = (PageDetail) obj;
		if (pageLink == null) {
			if (other.pageLink != null)
				return false;
		} else if (!pageLink.equals(other.pageLink))
			return false;
		return true;
	}

}
