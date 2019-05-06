package cn.zhang.diary.service.impl;

import cn.zhang.diary.dao.ConsumeDAO;
import cn.zhang.diary.model.Consume;
import cn.zhang.diary.model.Diary;
import cn.zhang.diary.service.ConsumeService;
import cn.zhang.diary.service.DiaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 消费服务类
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {

    /**
     * 消费DAO
     */
    @Resource
    private ConsumeDAO consumeDAO;

    /**
     * 日记DAO
     */
    @Resource
    private DiaryService diaryService;

    /**
     * 查询列表
     *
     * @param consume
     * @return
     */
    @Override
    public List<Consume> queryList(Consume consume) {
        return consumeDAO.selectByConsume(consume);
    }

    /**
     * 增加消费
     *
     * @param consume
     * @return
     */
    @Override
    public int add(Consume consume) {
        //查询日记日期
        Long diaryId = consume.getDiaryId();
        Diary diary = diaryService.queryById(diaryId);
        consume.setDate(diary.getDate());
        consume.setCreateTime(new Date());
        consume.setUpdateTime(new Date());
        return consumeDAO.insert(consume);
    }

    /**
     * 更新消费
     *
     * @param consume
     * @return
     */
    @Override
    public int update(Consume consume) {
        return consumeDAO.updateById(consume);
    }

    /**
     * 查询ID
     *
     * @param id
     * @return
     */
    @Override
    public Consume queryById(Long id) {
        Consume consume = new Consume();
        consume.setId(id);
        List<Consume> list = consumeDAO.selectByConsume(consume);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
