package cn.zhang.diary.service.impl;

import cn.zhang.diary.dao.DiaryDAO;
import cn.zhang.diary.dto.DiaryDTO;
import cn.zhang.diary.model.Diary;
import cn.zhang.diary.service.DiaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    /**
     * 根据ID查询列表
     *
     * @param id
     * @return
     */
    @Override
    public Diary queryById(Long id) {
        DiaryDTO diary = new DiaryDTO();
        diary.setId(id);
        List<Diary> list = diaryDAO.selectByDiary(diary);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 新增日记
     *
     * @param diary
     * @return
     */
    @Override
    public int add(Diary diary) {
        diary.setCreateTime(new Date());
        diary.setUpdateTime(new Date());
        return diaryDAO.insert(diary);
    }

    /**
     * 更新日记
     *
     * @param diary
     * @return
     */
    @Override
    public int update(Diary diary) {
        return diaryDAO.updateById(diary);
    }
}
