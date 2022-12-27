package com.example.blog.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.ArticleTag;
import org.springframework.stereotype.Repository;


/**
 * 文章标签
 *
 * @author yezhiqiu
 * @date 2021/08/10
 */
@Repository
public interface ArticleTagDao extends BaseMapper<ArticleTag> {

}
