package com.itkim.dao;

import com.itkim.pojo.TbPlaylistMusic;
import com.itkim.pojo.TbPlaylistMusicExample;
import com.itkim.pojo.TbPlaylistMusicKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPlaylistMusicMapper {
    int countByExample(TbPlaylistMusicExample example);

    int deleteByExample(TbPlaylistMusicExample example);

    int deleteByPrimaryKey(TbPlaylistMusicKey key);

    int insert(TbPlaylistMusic record);

    int insertSelective(TbPlaylistMusic record);

    List<TbPlaylistMusic> selectByExample(TbPlaylistMusicExample example);

    TbPlaylistMusic selectByPrimaryKey(TbPlaylistMusicKey key);

    int updateByExampleSelective(@Param("record") TbPlaylistMusic record, @Param("example") TbPlaylistMusicExample example);

    int updateByExample(@Param("record") TbPlaylistMusic record, @Param("example") TbPlaylistMusicExample example);

    int updateByPrimaryKeySelective(TbPlaylistMusic record);

    int updateByPrimaryKey(TbPlaylistMusic record);
}