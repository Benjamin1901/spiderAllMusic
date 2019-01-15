package com.itkim;

import com.itkim.dao.TbAllMusicMapper;
import com.itkim.dao.TbPlaylistMusicMapper;
import com.itkim.pojo.TbPlaylistMusic;
import com.itkim.tools.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @description: TODO
 * @author: KimJun
 * @date: 18/12/27 18:22
 */
public class mybatisTest {

    @Test
    public void test1() {
        SqlSession session = DBTools.getSession();
        TbAllMusicMapper mapper = session.getMapper(TbAllMusicMapper.class);
        TbPlaylistMusicMapper mapper1 = session.getMapper(TbPlaylistMusicMapper.class);
        List<TbPlaylistMusic> list = mapper1.selectByExample(null);
        for (int i = 0; i < list.size(); i++) {
            TbPlaylistMusic music = list.get(i);
//            mapper.insert(new TbAllMusic(music.getSongid(), music.getSongname(), music.getSongsinger(), music.getSongurl(), music.getOuterurl()));
        }
        session.commit();
    }
}
