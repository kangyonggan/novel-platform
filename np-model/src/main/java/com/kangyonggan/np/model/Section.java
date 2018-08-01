package com.kangyonggan.np.model;

import java.util.Date;
import javax.persistence.*;

import com.github.ofofs.jca.annotation.Serial;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@Table(name = "tb_section")
@Data
@Serial
public class Section {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 章节代码
     */
    private Integer code;

    /**
     * 标题
     */
    private String title;

    /**
     * 小说代码
     */
    @Column(name = "novel_code")
    private Integer novelCode;

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

    /**
     * 内容
     */
    private String content;
}