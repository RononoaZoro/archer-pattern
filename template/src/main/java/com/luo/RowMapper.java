package com.luo;

import javax.xml.transform.Result;
import java.sql.ResultSet;

/**
 * @author luoxuzheng
 * @create 2019-08-13 16:06
 **/
public interface RowMapper<T> {

    T mapRow(ResultSet rs,int rowNum) throws Exception;
}
