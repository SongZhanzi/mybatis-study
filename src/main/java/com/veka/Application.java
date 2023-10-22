package com.veka;
/*
 *@Author：Veka
 *@Project：mybatis-study
 *@Date：2023/10/22  10:58
 */

import com.veka.mapper.UserInfoMapper;
import com.veka.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

public class Application {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        mapper.selectUserInfoByIds(Arrays.asList(1l,2l,1l,3l));

    }

    private static void UpdateUserInfoByParam() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("Tony2");
        userInfo.setUserPassword("112");
        userInfo.setUserId(1l);
        mapper.UpdateUserInfoByParam(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void queryUserInfoByParam() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("Tony");
        userInfo.setUserPassword("");
        List<UserInfo> userInfos = mapper.queryUserInfoByParam(userInfo);
        userInfos.forEach(e -> System.out.println("userInfo:" + e));
        sqlSession.close();
    }

    private static void queryUserInfoByUsernameAndPwd() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = mapper.queryUserInfoByUsernameAndPwd("'Tony'","'111'");
        System.out.println(userInfo);
    }

    private static void deleteUserById() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        mapper.deleteUserById(5l);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void insertUserInfo() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("1s");
        userInfo.setUserPassword("555");
        //userInfo.setCreateTime(Date CURRENT_TIMESTAMP);-- 不用添加时间，自动输入当前时间
        mapper.insertUserInfo(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void updateUsernameById() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        mapper.updateUsernameById("zs",3l);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void getAllUserInfo() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> userInfos = mapper.selectAllUsers();
        userInfos.forEach(e -> System.out.println("userInfo:" + e));
        sqlSession.close();
    }

    private static void getMysqlSimple() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserInfo user = sqlSession.selectOne("selectUser", 1);
        System.out.println(user);
        sqlSession.close();
    }

    private static SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }


}
