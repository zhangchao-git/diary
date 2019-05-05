package cn.zhang.diary.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 日记记录
 */
@Getter
@Setter
public class Diary {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 日期
     */
    private String date;

    /**
     * 天气
     */
    private String weather;

    /**
     * 心情
     */
    private String mood;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 记录类型
     */
    private String type;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}