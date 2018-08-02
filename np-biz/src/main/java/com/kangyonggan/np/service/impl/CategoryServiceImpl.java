package com.kangyonggan.np.service.impl;

import com.kangyonggan.common.BaseService;
import com.kangyonggan.common.Status;
import com.kangyonggan.extra.core.annotation.Log;
import com.kangyonggan.np.model.Category;
import com.kangyonggan.np.service.CategoryService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/2/18
 */
@Service
public class CategoryServiceImpl extends BaseService<Category> implements CategoryService {

    @Override
    @Log
    public List<Category> findCategoriesByType(String type) {
        Example example = new Example(Category.class);

        example.createCriteria().andEqualTo("type", type)
                .andEqualTo("status", Status.ENABLE.getCode());

        example.setOrderByClause("sort asc");
        return myMapper.selectByExample(example);
    }

}
