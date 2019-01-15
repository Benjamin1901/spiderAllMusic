package com.itkim.dao;

import com.itkim.pojo.TbComments;
import com.itkim.pojo.TbCommentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCommentsMapper {
    int countByExample(TbCommentsExample example);

    int deleteByExample(TbCommentsExample example);

    int deleteByPrimaryKey(Long commentid);

    int insert(TbComments record);

    int insertSelective(TbComments record);

    List<TbComments> selectByExample(TbCommentsExample example);

    TbComments selectByPrimaryKey(Long commentid);

    int updateByExampleSelective(@Param("record") TbComments record, @Param("example") TbCommentsExample example);

    int updateByExample(@Param("record") TbComments record, @Param("example") TbCommentsExample example);

    int updateByPrimaryKeySelective(TbComments record);

    int updateByPrimaryKey(TbComments record);
}