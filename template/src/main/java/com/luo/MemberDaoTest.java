package com.luo;

import com.luo.dao.MemberDao;

/**
 * @author luoxuzheng
 * @create 2019-08-13 16:02
 **/
public class MemberDaoTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao();
        try {
            memberDao.query();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
