package cn.zhang.diary.dao;

import cn.zhang.diary.dto.DiaryDTO;
import cn.zhang.diary.model.Diary;

import java.util.List;

/**
 * 日记DAO
 */
public interface DiaryDAO {

    int insert(Diary record);

    int deleteById(Long id);

    List<Diary> selectByDiary(DiaryDTO diaryDTO);

    int updateById(Diary diary);
}