package com.kangyonggan.np.model;

import java.util.Date;
import javax.persistence.*;

import com.github.ofofs.jca.annotation.Serial;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@Table(name = "tb_category")
@Data
@Serial
public class Category {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 栏目代码
     */
    private String code;

    /**
     * 栏目名称
     */
    private String name;

    /**
     * 栏目类型
     */
    private String type;

    /**
     * 栏目排序(从0开始)
     */
    private Integer sort;

    /**
     * 状态:{0:可用, 1:禁用}
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;
}