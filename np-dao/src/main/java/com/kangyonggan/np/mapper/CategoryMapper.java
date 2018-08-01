package com.kangyonggan.np.mapper;

import com.kangyonggan.np.model.Category;
import com.kangyonggan.common.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@Mapper
public interface CategoryMapper extends MyMapper<Category> {
}