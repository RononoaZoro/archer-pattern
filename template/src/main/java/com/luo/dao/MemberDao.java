package com.luo.dao;

import com.luo.JdbcTemplate;
import com.luo.RowMapper;
import com.luo.entity.Member;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author luoxuzheng
 * @create 2019-08-13 16:03
 **/
public class MemberDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<?> query() throws Exception {
        String sql = "select * from t_member";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        },null);
    }
}
