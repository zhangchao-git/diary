package cn.zhang.diary.dao;

import cn.zhang.diary.model.Diary;

import java.util.List;

/**
 * 日记DAO
 */
public interface DiaryDAO {

    int insert(Diary record);

    int deleteById(Long id);

    List<Diary> selectByDiary(Diary diary);

    int updateById(Diary record);
}