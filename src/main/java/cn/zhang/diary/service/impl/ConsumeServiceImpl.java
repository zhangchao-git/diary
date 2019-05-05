package cn.zhang.diary.service.impl;

import cn.zhang.diary.dao.ConsumeDAO;
import cn.zhang.diary.model.Consume;
import cn.zhang.diary.service.ConsumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConsumeServiceImpl implements ConsumeService {

    @Resource
    private ConsumeDAO consumeDAO;

    @Override
    public List<Consume> queryList(Consume consume) {
        return consumeDAO.selectByConsume(consume);
    }

    @Override
    public int add(Consume consume) {
        return consumeDAO.insert(consume);
    }

    @Override
    public int update(Consume consume) {
        return consumeDAO.updateById(consume);
    }
}
