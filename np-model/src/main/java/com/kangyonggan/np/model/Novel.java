package com.kangyonggan.np.model;

import java.util.Date;
import javax.persistence.*;

import com.github.ofofs.jca.annotation.Serial;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@Table(name = "tb_novel")
@Data
@Serial
public class Novel {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 栏目代码
     */
    @Column(name = "category_code")
    private String categoryCode;

    /**
     * 封面图片地址
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 书籍代码
     */
    private Integer code;

    /**
     * 描述
     */
    private String descp;

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