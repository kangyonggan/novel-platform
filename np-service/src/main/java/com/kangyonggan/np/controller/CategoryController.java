package com.kangyonggan.np.controller;

import com.kangyonggan.common.web.BaseController;
import com.kangyonggan.np.model.Category;
import com.kangyonggan.np.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/2/18
 */
@RestController
@RequestMapping("category")
public class CategoryController extends BaseController {


    @Autowired
    private CategoryService categoryService;

    /**
     * 栏目列表
     *
     * @param type
     * @return
     */
    @GetMapping
    public List<Category> list(@RequestParam("type") String type) {
        return categoryService.findCategoriesByType(type);
    }

}
