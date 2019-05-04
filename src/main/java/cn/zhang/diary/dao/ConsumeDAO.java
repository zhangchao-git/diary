package cn.zhang.diary.dao;

import cn.zhang.diary.model.Consume;

import java.util.List;

/**
 * 消费DAO
 */
public interface ConsumeDAO {

    int insert(Consume consume);

    int deleteById(Long id);

    List<Consume> selectByConsume(Consume consume);

    int updateById(Consume record);
}