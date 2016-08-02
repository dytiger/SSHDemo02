package org.forten.poem.qo;

/**
 * Created by Administrator on 2016/8/2.
 */
public class SearchPoemQo {
    private String title;
    private String author;
    private String dynasty;
    private String poemKeyword;

    public SearchPoemQo() {

    }

    public SearchPoemQo(String title, String author, String dynasty, String poemKeyword) {
        this.title = title;
        this.author = author;
        this.dynasty = dynasty;
        this.poemKeyword = poemKeyword;
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

    public String getPoemKeyword() {
        return poemKeyword;
    }

    public void setPoemKeyword(String poemKeyword) {
        this.poemKeyword = poemKeyword;
    }

    @Override
    public String toString() {
        return "SearchPoemQo{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", poemKeyword='" + poemKeyword + '\'' +
                '}';
    }
}
