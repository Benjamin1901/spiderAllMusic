package com.itkim.dao;

import com.itkim.pojo.TbAllSinger;
import com.itkim.pojo.TbAllSingerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAllSingerMapper {
    int countByExample(TbAllSingerExample example);

    int deleteByExample(TbAllSingerExample example);

    int deleteByPrimaryKey(Long singerid);

    int insert(TbAllSinger record);

    int insertSelective(TbAllSinger record);

    List<TbAllSinger> selectByExample(TbAllSingerExample example);

    TbAllSinger selectByPrimaryKey(Long singerid);

    int updateByExampleSelective(@Param("record") TbAllSinger record, @Param("example") TbAllSingerExample example);

    int updateByExample(@Param("record") TbAllSinger record, @Param("example") TbAllSingerExample example);

    int updateByPrimaryKeySelective(TbAllSinger record);

    int updateByPrimaryKey(TbAllSinger record);
}