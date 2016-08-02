package org.forten.poem.bo;

import org.forten.poem.dao.JdbcDao;
import org.forten.poem.qo.SearchPoemQo;
import org.forten.poem.vo.PoemForList;
import org.forten.poem.vo.PoemForSave;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/2.
 */
@Service("poemBo")
public class PoemBo {
    @Resource
    private JdbcDao jdbcDao;

    @Transactional
    public void doSave(PoemForSave poem){
        String sql = "INSERT INTO poem (title,author,dynasty,poem_text,create_time) " +
                "VALUES (:title,:author,:dynasty,:pt,:ct)";
        Map<String,Object> params = new HashMap<>();
        params.put("title",poem.getTitle());
        params.put("author",poem.getAuthor());
        params.put("dynasty",poem.getDynasty());
        params.put("pt",poem.getPoemText());
        params.put("ct",poem.getCreateTime());

        jdbcDao.update(sql,params);
    }

    @Transactional(readOnly = true)
    public List<PoemForList> queryBy(SearchPoemQo qo){
        String sql = "SELECT id,title,author,dynasty,poem_text,create_time " +
                "FROM poem WHERE 1=1 ";
        Map<String,Object> params = new HashMap<>();
        if(qo.getAuthor()!=null&&!qo.getAuthor().equals("")){
            sql = sql + "AND author LIKE :a ";
            params.put("a","%"+qo.getAuthor()+"%");
        }
        if(qo.getTitle()!=null&&!qo.getTitle().equals("")){
            sql = sql + "AND title LIKE :t ";
            params.put("t","%"+qo.getTitle()+"%");
        }
        if(qo.getDynasty()!=null&&!qo.getDynasty().equals("")){
            sql = sql + "AND dynasty LIKE :d ";
            params.put("d","%"+qo.getDynasty()+"%");
        }
        if(qo.getPoemKeyword()!=null&&!qo.getPoemKeyword().equals("")){
            sql = sql + "AND poem_text LIKE :kw ";
            params.put("kw","%"+qo.getPoemKeyword()+"%");
        }
        sql = sql + "ORDER BY create_time DESC";

        List<PoemForList> list = jdbcDao.findBy(sql,params,(rs,i)->{
            PoemForList vo = new PoemForList();
            vo.setCreateTime(rs.getTimestamp("create_time"));
            vo.setTitle(rs.getString("title"));
            vo.setAuthor(rs.getString("author"));
            vo.setDynasty(rs.getString("dynasty"));
            vo.setPoemText(rs.getString("poem_text"));
            vo.setId(rs.getInt("id"));
            return vo;
        });

        return list;
    }

    @Transactional
    public void doDelete(int id){
        String sql = "DELETE FROM poem WHERE id=:id";
        Map<String,Object> param = new HashMap<>(1);
        param.put("id",id);

        jdbcDao.update(sql,param);
    }

    @Transactional(readOnly = true)
    public PoemForList queryById(int id){
        String sql = "SELECT id,title,author,dynasty,poem_text " +
                "FROM poem WHERE id=:id ";
        Map<String,Object> param = new HashMap<>(1);
        param.put("id",id);

        return jdbcDao.findSingleObjectBy(sql,param,(rs,i)->{
            PoemForList vo = new PoemForList();
            vo.setTitle(rs.getString("title"));
            vo.setAuthor(rs.getString("author"));
            vo.setDynasty(rs.getString("dynasty"));
            vo.setPoemText(rs.getString("poem_text"));
            vo.setId(rs.getInt("id"));
            return vo;
        });
    }

    @Transactional
    public void doUpdate(PoemForList vo){
        String sql = "UPDATE poem SET title=:t,author=:a,dynasty=:d,poem_text=:pt WHERE id=:id";
        Map<String,Object> param = new HashMap<>(1);
        param.put("id",vo.getId());
        param.put("t",vo.getTitle());
        param.put("a",vo.getAuthor());
        param.put("d",vo.getDynasty());
        param.put("pt",vo.getPoemText());

        jdbcDao.update(sql,param);
    }
}
