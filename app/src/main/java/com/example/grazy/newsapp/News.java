package com.example.grazy.newsapp;

import java.util.Date;

/**
 * {@link News} object contains information related to a specific news.
 */
public class News {

    /**
     * Web title of the news
     */
    private String mWebTitle;

    /**
     * Section name of the news
     */
    private String mSectionName;

    /**
     * Author name of the news
     */
    private String mAuthorName;

    /**
     * Publication date of the news
     */
    private Date mPublicationDate;

    /**
     * Website URL of the news
     */
    private String mUrl;

    /**
     * Create a News object.
     *
     * @param webTitle        is the web title of the news
     * @param sectionName     is the section name of the news
     * @param authorName      is the author name of the news
     * @param publicationDate is the publication date of the news
     * @param url             is the website URL to find more details about the news
     */
    public News(String webTitle, String sectionName, String authorName, Date publicationDate, String url) {
        mWebTitle = webTitle;
        mSectionName = sectionName;
        mAuthorName = authorName;
        mPublicationDate = publicationDate;
        mUrl = url;
    }

    /**
     * Returns the web title of the news
     */
    public String getWebTitle() {
        return mWebTitle;
    }

    /**
     * Returns the section name of the news
     */
    public String getSectionName() {
        return mSectionName;
    }

    /**
     * Returns the author name of the news
     */
    public String getAuthorName() {
        return mAuthorName;
    }

    /**
     * Returns the publication date of the news
     */
    public Date getPublicationDate() {
        return mPublicationDate;
    }

    /**
     * Returns the website URL to find more information about the news.
     */
    public String getUrl() {
        return mUrl;
    }
}