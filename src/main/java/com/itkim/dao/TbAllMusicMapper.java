package com.itkim.dao;

import com.itkim.pojo.TbAllMusic;
import com.itkim.pojo.TbAllMusicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAllMusicMapper {
    int countByExample(TbAllMusicExample example);

    int deleteByExample(TbAllMusicExample example);

    int deleteByPrimaryKey(Long songid);

    int insert(TbAllMusic record);

    int insertSelective(TbAllMusic record);

    List<TbAllMusic> selectByExample(TbAllMusicExample example);

    TbAllMusic selectByPrimaryKey(Long songid);

    int updateByExampleSelective(@Param("record") TbAllMusic record, @Param("example") TbAllMusicExample example);

    int updateByExample(@Param("record") TbAllMusic record, @Param("example") TbAllMusicExample example);

    int updateByPrimaryKeySelective(TbAllMusic record);

    int updateByPrimaryKey(TbAllMusic record);
}