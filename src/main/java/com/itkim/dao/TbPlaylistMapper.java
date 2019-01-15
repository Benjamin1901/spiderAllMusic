package com.itkim.dao;

import com.itkim.pojo.TbPlaylist;
import com.itkim.pojo.TbPlaylistExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPlaylistMapper {
    int countByExample(TbPlaylistExample example);

    int deleteByExample(TbPlaylistExample example);

    int deleteByPrimaryKey(Long playlistid);

    int insert(TbPlaylist record);

    int insertSelective(TbPlaylist record);

    List<TbPlaylist> selectByExample(TbPlaylistExample example);

    TbPlaylist selectByPrimaryKey(Long playlistid);

    int updateByExampleSelective(@Param("record") TbPlaylist record, @Param("example") TbPlaylistExample example);

    int updateByExample(@Param("record") TbPlaylist record, @Param("example") TbPlaylistExample example);

    int updateByPrimaryKeySelective(TbPlaylist record);

    int updateByPrimaryKey(TbPlaylist record);
}