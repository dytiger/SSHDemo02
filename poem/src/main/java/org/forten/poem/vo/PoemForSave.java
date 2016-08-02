package org.forten.poem.vo;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/2.
 */
public class PoemForSave {
    private String title;
    private String author;
    private String dynasty;
    private String poemText;
    private Date createTime;

    public PoemForSave() {
        this.createTime = new Date();
    }

    public PoemForSave(String title, String author, String dynasty, String poemText) {
        this();
        this.title = title;
        this.author = author;
        this.dynasty = dynasty;
        this.poemText = poemText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getPoemText() {
        return poemText;
    }

    public void setPoemText(String poemText) {
        this.poemText = poemText;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "PoemForSave{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", poemText='" + poemText + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
