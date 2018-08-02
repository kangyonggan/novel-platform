package com.kangyonggan.np.controller;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.common.web.BaseController;
import com.kangyonggan.np.model.Novel;
import com.kangyonggan.np.service.NovelService;
import com.kangyonggan.np.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@RestController
@RequestMapping("novel")
public class NovelController extends BaseController {

    @Autowired
    private NovelService novelService;

    @Autowired
    private SectionService sectionService;

    /**
     * 小说列表
     *
     * @return
     */
    @GetMapping
    public PageInfo<Novel> list() {
        List<Novel> novels = novelService.searchNovels(getRequestParams());
        return new PageInfo<>(novels);
    }

    /**
     * 小说详情
     *
     * @param code
     * @return
     */
    @GetMapping("{code:[\\w]+}")
    public Novel detail(@PathVariable("code") Integer code) {
        return novelService.findNovelByCode(code);
    }

    /**
     * 拉取最新章节
     *
     * @param code
     * @return
     */
    @PutMapping(value = "{code:[\\w]+}/pull")
    public boolean pull(@RequestParam("code") Integer code) {
        sectionService.updateSections(code);
        return true;
    }

    /**
     * 小说恢复/禁用
     *
     * @param id
     * @param status
     * @return
     */
    @PutMapping(value = "{id:[\\d]+}/status/{status:\\b0\\b|\\b1\\b}")
    public boolean status(@PathVariable("id") Long id, @PathVariable("status") byte status) {
        Novel novel = new Novel();
        novel.setId(id);
        novel.setStatus(status);
        novelService.updateNovel(novel);
        return true;
    }
}
