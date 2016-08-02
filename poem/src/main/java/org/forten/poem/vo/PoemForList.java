package org.forten.poem.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/2.
 */
public class PoemForList {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    private int id;
    private String title;
    private String author;
    private String dynasty;
    private String poemText;
    private Date createTime;

    public PoemForList() {
    }

    public PoemForList(int id, String title, String author, String dynasty, String poemText, Date createTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dynasty = dynasty;
        this.poemText = poemText;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr(){
        if(this.createTime!=null) {
            return sdf.format(this.createTime);
        }else{
            return "";
        }
    }

    @Override
    public String toString() {
        return "PoemForList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", poemText='" + poemText + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
