package cn.zhang.diary.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 消费记录
 */
@Getter
@Setter
public class Consume {
    /**
     * 主键
     */
    private Long id;
    /**
     * 记录ID
     */
    private Long diaryId;

    /**
     * 类型 收入/支出
     */
    private Integer type;

    /**
     * 收入支出路径
     */
    private String path;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}