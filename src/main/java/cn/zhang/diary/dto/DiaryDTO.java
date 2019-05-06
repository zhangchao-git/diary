package cn.zhang.diary.dto;

import cn.zhang.diary.model.Diary;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: zhangchao
 * @Date: 2019/5/5 13:53
 */
@Setter
@Getter
public class DiaryDTO extends Diary {

    /**
     * 消费金额
     */
    Double consume;

    /**
     * 收入
     */
    Double income;

    /**
     * 查询日期
     */
    String searchMonth;


}
