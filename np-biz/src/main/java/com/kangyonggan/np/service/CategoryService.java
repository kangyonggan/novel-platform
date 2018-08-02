package com.kangyonggan.np.service;

import com.kangyonggan.np.model.Category;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/2/18
 */
public interface CategoryService {

    /**
     * 根据栏目类型查找栏目
     *
     * @param type
     * @return
     */
    List<Category> findCategoriesByType(String type);
}
