package cn.zhang.diary.service;

import cn.zhang.diary.model.Consume;

import java.util.List;

/**
 * 消费serivce
 */
public interface ConsumeService {

    /**
     * 查询列表
     *
     * @param consume
     * @return
     */
    List<Consume> queryList(Consume consume);

    /**
     * 增加消费
     *
     * @param consume
     * @return
     */
    int add(Consume consume);

    /**
     * 更新消费
     *
     * @param consume
     * @return
     */
    int update(Consume consume);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    Consume queryById(Long id);
}
