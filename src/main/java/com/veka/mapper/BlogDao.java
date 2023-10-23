package com.veka.mapper;

import com.veka.po.Blog;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Blog)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-23 12:13:35
 */
public interface BlogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param blogId 主键
     * @return 实例对象
     */
    Blog queryById(Long blogId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询条件
     * @param limit         分页对象
     * @return 对象列表
     */
    List<Blog> queryAllByLimit(@Param("offset")int offset, @Param("limit") int limit);
    List<Blog> queryAll(Blog blog);

    /**
     * 统计总行数
     *
     * @param blog 查询条件
     * @return 总行数
     */
    long count(Blog blog);

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 影响行数
     */
    int insert(Blog blog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Blog> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Blog> entities);

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 影响行数
     */
    int update(Blog blog);

    /**
     * 通过主键删除数据
     *
     * @param blogId 主键
     * @return 影响行数
     */
    int deleteById(Long blogId);

}

