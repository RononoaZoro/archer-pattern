package com.luo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxuzheng
 * @create 2019-08-13 16:03
 **/
public class JdbcTemplate {

    //jdbc执行流程
    //1、注册驱动
    //2、建立连接
    //3、创建语句
    //4、执行语句
    //5、解析结果
    //6、释放资源

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper,
                                Object[] values) throws Exception {

        //1、获取连接
        Connection conn = this.getConnection();

        //2、创建语句集
        PreparedStatement pstmt = this.createPreparedStatement(conn, sql);

        //3、执行语句集，并获取结果集
        ResultSet rs = this.executeQuery(pstmt, values);

        //4、解析结果集
        List<?> result = this.parseResultSet(rs, rowMapper);

        //5、关闭结果集
        this.closeResultSet(rs);

        //6、关闭语句集
        this.closePrepareStatement(pstmt);

        //7、关闭连接
        this.closeConnection(conn);

        return result;
    }

    /**
     * 关闭连接
     *
     * @param conn
     */
    private void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

    /**
     * 关闭语句集
     *
     * @param pstmt
     */
    private void closePrepareStatement(PreparedStatement pstmt) throws SQLException {
        pstmt.close();
    }

    /**
     * 关闭结果集
     *
     * @param rs
     */
    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    /**
     * 解析结果集
     *
     * @param rs
     * @param rowMapper
     * @return
     */
    private List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 0;
        while (rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    /**
     * 执行语句集
     *
     * @param pstmt
     * @param values
     * @return
     */
    private ResultSet executeQuery(PreparedStatement pstmt, Object[] values) throws SQLException {
        int i = 0;
        for (Object value : values) {
            pstmt.setObject(i++, value);
        }
        return pstmt.executeQuery();
    }


    /**
     * 创建语句集
     *
     * @param conn
     * @param sql
     * @return
     */
    private PreparedStatement createPreparedStatement(Connection conn, String sql) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        return preparedStatement;
    }

    /**
     * 获取连接
     *
     * @return
     */
    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

}
