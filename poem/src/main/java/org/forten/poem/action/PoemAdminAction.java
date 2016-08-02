package org.forten.poem.action;

import com.mchange.v2.log.jdk14logging.ForwardingLogger;
import org.forten.poem.bo.PoemBo;
import org.forten.poem.qo.SearchPoemQo;
import org.forten.poem.vo.PoemForList;
import org.forten.poem.vo.PoemForSave;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
@Controller
public class PoemAdminAction {
    @Resource
    private PoemBo poemBo;

    @RequestMapping("/admin/save")
    public String save(PoemForSave poem){
        poemBo.doSave(poem);
        return "redirect:list.do";
    }

    @RequestMapping("/admin/list")
    public ModelAndView list(SearchPoemQo qo){
        List<PoemForList> list = poemBo.queryBy(qo);
        ModelAndView mav = new ModelAndView();
        mav.addObject("data",list);
        mav.addObject("qo",qo);
        mav.setViewName("list.jsp");
        return mav;
    }

    @RequestMapping("/admin/delete")
    public String delete(int id){
        poemBo.doDelete(id);
        return "redirect:list.do";
    }

    @RequestMapping("/admin/gotoUpdate")
    public ModelAndView gotoUpdate(int id){
        PoemForList vo = poemBo.queryById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("vo",vo);
        mav.setViewName("update.jsp");
        return mav;
    }

    @RequestMapping("/admin/update")
    public String update(PoemForList vo){
        poemBo.doUpdate(vo);
        return "redirect:list.do";
    }
}
