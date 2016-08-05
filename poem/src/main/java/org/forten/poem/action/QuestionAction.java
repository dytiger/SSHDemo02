package org.forten.poem.action;

import org.forten.poem.bo.PoemBo;
import org.forten.poem.bo.QuestionBo;
import org.forten.poem.vo.PoemForList;
import org.forten.poem.vo.QuestionForShow;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/8/4.
 */
@Controller
public class QuestionAction {
    @Resource
    private QuestionBo questionBo;
    @Resource
    private PoemBo poemBo;

    @RequestMapping("/question/getQuestion")
    public @ResponseBody QuestionForShow getQuestion(){
        QuestionForShow vo = questionBo.getQuestion();
        return vo;
    }

    @RequestMapping("/question/getAnswer")
    public @ResponseBody PoemForList getAnswer(int id){
        return poemBo.queryById(id);
    }
}
