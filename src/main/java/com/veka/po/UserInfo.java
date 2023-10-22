package com.veka.po;
/*
 *@Author：Veka
 *@Project：mybatis-study
 *@Date：2023/10/22  11:23
 */

import lombok.Data;

import java.util.Date;

//和表的字段一一映射
@Data
public class UserInfo {
    /*
    user_id             bigint auto_increment comment '用户ID' primary key,
    username         varchar(50)      null default '' comment  '用户名',
    user_password    varchar(50)    null default '' comment '用户密码',
    create_time  timestamp  default 0 not null comment '创建时间',
    update_time  timestamp  default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment
     */
    private Long userId;
    private String username;
    private String userPassword;
    private Date createTime;
    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
