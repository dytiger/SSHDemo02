package org.forten.poem.vo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
public class QuestionForShow {
    private int id;
    private List<String> question;
    private String answer;

    public QuestionForShow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getQuestion() {
        return question;
    }

    public void setQuestion(List<String> question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionForShow{" +
                "id=" + id +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                '}';
    }
}
