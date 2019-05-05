package cn.zhang.diary.service.impl;

import cn.zhang.diary.dao.DiaryDAO;
import cn.zhang.diary.dto.DiaryDTO;
import cn.zhang.diary.model.Diary;
import cn.zhang.diary.service.DiaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日历diary
 *
 * @Auther: zhangchao
 * @Date: 2019/5/5 13:51
 */
@Service
public class DiaryServiceImpl implements DiaryService {

    /**
     * 日历DAO
     */
    @Resource
    private DiaryDAO diaryDAO;

    /**
     * 查询列表
     *
     * @param diaryDTO
     * @return
     */
    @Override
    public List<Diary> queryList(DiaryDTO diaryDTO) {
        List<Diary> list = diaryDAO.selectByDiary(diaryDTO);
        return list;
    }
}
