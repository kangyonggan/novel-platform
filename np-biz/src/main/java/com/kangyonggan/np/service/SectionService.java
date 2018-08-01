package com.kangyonggan.np.service;

import com.kangyonggan.common.Params;
import com.kangyonggan.np.model.Section;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
public interface SectionService {

    /**
     * 查找小说全部章节
     *
     * @param params
     * @return
     */
    List<Section> findNovelSections(Params params);

    /**
     * 查找章节详情
     *
     * @param sectionCode
     * @return
     */
    Section findSectionByCode(Integer sectionCode);

    /**
     * 拉取最新章节
     *
     * @param novelCode
     */
    void updateSections(Integer novelCode);

    /**
     * 查找上一章
     *
     * @param code
     * @return
     */
    Section findPrevSectionByCode(Integer code);

    /**
     * 查找下一章
     *
     * @param code
     * @return
     */
    Section findNextSectionByCode(Integer code);

    /**
     * 更新书籍章节
     *
     * @param novelCodes
     */
    void updateNovelSections(List<Integer> novelCodes);
}
