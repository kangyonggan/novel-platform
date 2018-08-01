package com.kangyonggan.np.mapper;

import com.kangyonggan.common.Query;
import com.kangyonggan.common.mybatis.MyMapper;
import com.kangyonggan.np.model.Novel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@Mapper
public interface NovelMapper extends MyMapper<Novel> {

    /**
     * 搜索小说
     *
     * @param query
     * @return
     */
    List<Novel> searchNovels(@Param("query") Query query);
}