package org.forten.poem.bo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/8/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/app-*.xml"})
public class PoemBoTest {
    @Resource(name="questionBo")
    private QuestionBo bo;

    @Test
    public void testGetQuestion(){
        System.out.println(bo.getQuestion());
    }
}
