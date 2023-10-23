package com.veka.mapper;
/*
 *@Author：Veka
 *@Project：mybatis-study
 *@Date：2023/10/22  14:42
 */

import com.veka.po.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserInfoMapper {
    /**
     * 根据主键id获取userInfo
     *
     * @param id
     * @return
     */
    UserInfo selectUserById(Long id);

    /**
     * 查询所有userinfo
     * @return
     */
    List<UserInfo> selectAllUsers();

    /**
     * 新增一条数据
     * @param userInfo
     * @return
     */
    Integer insertUserInfo(UserInfo userInfo);

    /**
     * 根据主键id修改用户名
     *
     * @param name
     * @param id
     * @return
     */
    Integer updateUsernameById(@Param("name") String name, @Param("id") Long id); //xml里认的是@Param("name")

    /**
     * 根据主键id删除
     * @param id
     * @return
     */
    Integer deleteUserById(Long id);

    UserInfo queryUserInfoByUsernameAndPwd(@Param("name") String name, @Param("password") String password);

    List<UserInfo>  queryUserInfoByUsernameOrPwd(UserInfo userInfo);

    List<UserInfo>  queryUserInfoByParam(UserInfo userInfo);

    Integer UpdateUserInfoByParam(UserInfo userInfo);

    List<UserInfo> selectUserInfoByIds(@Param("ids") List<Long> ids);

    List<UserInfo> selectUserInfoByPages(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    Integer userInfoCounts();



}
