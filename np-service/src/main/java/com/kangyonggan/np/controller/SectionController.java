package com.kangyonggan.np.controller;

import com.kangyonggan.common.Response;
import com.kangyonggan.common.web.BaseController;
import com.kangyonggan.np.model.Section;
import com.kangyonggan.np.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@RestController
@RequestMapping("section")
public class SectionController extends BaseController {

    @Autowired
    private SectionService sectionService;

    /**
     * 章节列表
     *
     * @return
     */
    @GetMapping
    public Response list() {
        Response response = Response.getSuccessResponse();
        List<Section> sections = sectionService.findNovelSections(getRequestParams());

        response.put("list", sections);
        return response;
    }

    /**
     * 章节详情
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\d]+}")
    public Response detail(@PathVariable("code") Integer code) {
        Response response = Response.getSuccessResponse();
        Section section = sectionService.findSectionByCode(code);

        response.put("section", section);
        return response;
    }

    /**
     * 上一章
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\d]+}/prev")
    public Response prev(@PathVariable("code") Integer code) {
        Response response = Response.getSuccessResponse();
        Section section = sectionService.findPrevSectionByCode(code);

        response.put("section", section);
        return response;
    }

    /**
     * 下一章
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\d]+}/next")
    public Response next(@PathVariable("code") Integer code) {
        Response response = Response.getSuccessResponse();
        Section section = sectionService.findNextSectionByCode(code);

        response.put("section", section);
        return response;
    }

}
