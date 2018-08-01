package com.kangyonggan.np.service.impl;

import com.github.pagehelper.PageHelper;
import com.kangyonggan.common.BaseService;
import com.kangyonggan.common.Params;
import com.kangyonggan.extra.core.annotation.Log;
import com.kangyonggan.np.mapper.NovelMapper;
import com.kangyonggan.np.model.Novel;
import com.kangyonggan.np.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@Service
public class NovelServiceImpl extends BaseService<Novel> implements NovelService {

    @Autowired
    private NovelMapper novelMapper;

    @Override
    @Log
    public List<Novel> searchNovels(Params params) {
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        return novelMapper.searchNovels(params.getQuery());
    }

    @Override
    @Log
    public void updateNovel(Novel novel) {
        myMapper.updateByPrimaryKeySelective(novel);
    }

    @Override
    @Log
    public Novel findNovelByCode(Integer code) {
        Novel novel = new Novel();
        novel.setCode(code);
        return myMapper.selectOne(novel);
    }
}
