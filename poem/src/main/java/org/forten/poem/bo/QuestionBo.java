package org.forten.poem.bo;

import org.forten.poem.dao.JdbcDao;
import org.forten.poem.vo.PoemForList;
import org.forten.poem.vo.QuestionForShow;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Administrator on 2016/8/4.
 */
@Service("questionBo")
public class QuestionBo {
    @Resource
    private JdbcDao jdbcDao;

    private static final char[] mixWords = {'红','青','空','盈','阳','阴','草','花','白','绿','任','充','岩','岸','江','河','海','志','远','芳','香','桃','李','冰','缘','虎','封','木','林','霜','雪','风','峰','炉','天','地','月','日','百','智','千'};

    @Transactional(readOnly = true)
    public QuestionForShow getQuestion(){
        // 查询所有诗歌的总数
        String sql = "SELECT count(id) FROM poem";
        long count = jdbcDao.findSingleObjectBy(sql,Long.class);

        // 随机得到一首诗词，并组装QuestionForShow类型的对象
        // 这个对象是不完整的，只添加了id和answer两个属性的值
        // question的数据要下一步生成
        Random random = new Random();
        int i = random.nextInt((int)count);
        sql = "SELECT id,poem_text FROM poem LIMIT :n,1";
        Map<String,Object> params = new HashMap<>(1);
        params.put("n",i);
        QuestionForShow question = jdbcDao.findSingleObjectBy(sql, params, new RowMapper<QuestionForShow>() {
            public QuestionForShow mapRow(ResultSet rs, int rowNum) throws SQLException {
                QuestionForShow show = new QuestionForShow();
                show.setId(rs.getInt("id"));
                String poem = rs.getString("poem_text");
                // 由诗歌的每一句组成的一个String数组
                String[] stats = poem.split("\\s+");
                show.setAnswer(stats[random.nextInt(stats.length)]);
                return show;
            }
        });

        // 生成question
        String answerText = question.getAnswer();

        for(int j = 0;j<4;j++){
            answerText =answerText+mixWords[random.nextInt(mixWords.length)];
        }

        StringBuilder sb = new StringBuilder(answerText);
        List<String> questionWordList = new ArrayList<>();
        while (sb.length()>0){
            int index = random.nextInt(sb.length());
            char t = sb.charAt(index);
            sb.deleteCharAt(index);
            questionWordList.add(""+t);
        }

        question.setQuestion(questionWordList);

        return question;
    }
}
