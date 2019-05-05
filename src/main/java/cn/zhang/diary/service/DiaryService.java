package cn.zhang.diary.service;

import cn.zhang.diary.dto.DiaryDTO;
import cn.zhang.diary.model.Diary;

import java.util.List;

/**
 * 日历diary
 *
 * @Auther: zhangchao
 * @Date: 2019/5/5 13:51
 */
public interface DiaryService {

    /**
     * 查询列表
     *
     * @param diaryDTO
     * @return
     */
    List<Diary> queryList(DiaryDTO diaryDTO);
}
