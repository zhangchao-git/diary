package cn.zhang.diary.service;

import cn.zhang.diary.model.Consume;

import java.util.List;

public interface ConsumeService {

    List<Consume> queryList(Consume consume);

    int add(Consume consume);

    int update(Consume consume);
}
