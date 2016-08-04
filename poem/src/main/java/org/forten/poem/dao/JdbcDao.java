package org.forten.poem.dao;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/28.
 */
@Repository("jdbcDao")
public class JdbcDao implements InitializingBean {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final Map<String,Object> EMPTY_PARAMS = new HashMap<String, Object>();

    /**
     * 对数据进行添加、删除、更新操作
     * @param sql 要被执行的SQL
     * @param params SQL中各命名参数的名值对
     * @return 影响的数据结果数量
     */
    public int update(String sql, Map<String,Object> params){
        return jdbcTemplate.update(sql,params);
    }

    /**
     * 查询符合条件的一批数据对象
     * @param sql 要被执行的SQL
     * @param params SQL中各命名参数的名值对
     * @param mapper 数据结果集合与Java对象之间的映射器
     * @param <T> 要查询的对象类型
     * @return 符合条件的一批数据对象List
     */
    public <T> List<T> findBy(String sql, Map<String, Object> params, RowMapper<T> mapper) {
        return jdbcTemplate.query(sql, params, mapper);
    }

    public <T> T findSingleObjectBy(String sql, Map<String, Object> params,Class<T> c) {
        return jdbcTemplate.queryForObject(sql, params,c);
    }
    public <T> T findSingleObjectBy(String sql, Class<T> c) {
        return jdbcTemplate.queryForObject(sql,EMPTY_PARAMS,c);
    }

    /**
     * 获取单条数据结果封装的对象
     * @param sql 要被执行的SQL
     * @param params SQL中各命名参数的名值对
     * @param mapper 数据结果集合与Java对象之间的映射器
     * @param <T> 要查询的对象类型
     * @return 单个的数据对象
     */
    public <T> T findSingleObjectBy(String sql, Map<String, Object> params, RowMapper<T> mapper) {
        try {
            return jdbcTemplate.queryForObject(sql, params, mapper);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void afterPropertiesSet() {
        if (dataSource == null) {
            throw new BeanCreationException("DataSource不可以为null");
        }
        if (jdbcTemplate == null) {
            throw new BeanCreationException("JdbcTemplate不可以是null");
        }
    }
}
