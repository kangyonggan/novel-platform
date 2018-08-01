package com.kangyonggan.np.controller;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.common.Response;
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
    public Response list() {
        Response response = Response.getSuccessResponse();

        List<Novel> novels = novelService.searchNovels(getRequestParams());
        PageInfo pageInfo = new PageInfo<>(novels);

        response.put("pageInfo", pageInfo);
        return response;
    }

    /**
     * 小说详情
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\d]+}")
    public Response detail(@PathVariable("code") Integer code) {
        Response response = Response.getSuccessResponse();
        Novel novel = novelService.findNovelByCode(code);

        response.put("novel", novel);
        return response;
    }

    /**
     * 拉取最新章节
     *
     * @param code
     * @return
     */
    @PutMapping(value = "{code:[\\d]+}/pull")
    public Response pull(@PathVariable("code") Integer code) {
        sectionService.updateSections(code);
        return Response.getSuccessResponse();
    }

    /**
     * 小说恢复/禁用
     *
     * @param id
     * @param status
     * @return
     */
    @PutMapping(value = "{id:[\\d]+}/status/{status:\\b0\\b|\\b1\\b}")
    public Response status(@PathVariable("id") Long id, @PathVariable("status") byte status) {
        Novel novel = new Novel();
        novel.setId(id);
        novel.setStatus(status);
        novelService.updateNovel(novel);
        return Response.getSuccessResponse();
    }
}
