package com.kangyonggan.np.controller;

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
    public List<Section> list() {
        return sectionService.findNovelSections(getRequestParams());
    }

    /**
     * 章节详情
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\w]+}")
    public Section detail(@PathVariable("code") Integer code) {
        return sectionService.findSectionByCode(code);
    }

    /**
     * 上一章
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\w]+}/prev")
    public Section prev(@PathVariable("code") Integer code) {
        return sectionService.findPrevSectionByCode(code);
    }

    /**
     * 下一章
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\w]+}/next")
    public Section next(@PathVariable("code") Integer code) {
        return sectionService.findNextSectionByCode(code);
    }

}
