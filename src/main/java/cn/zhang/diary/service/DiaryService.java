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
    List<DiaryDTO> queryList(DiaryDTO diaryDTO);

    /**
     * 根据ID查询列表
     *
     * @param id
     * @return
     */
    DiaryDTO queryById(Long id);

    /**
     * 增加日记
     *
     * @param diary
     * @return
     */
    int add(Diary diary);

    /**
     * 更新日记
     *
     * @param diary
     * @return
     */
    int update(Diary diary);
}
