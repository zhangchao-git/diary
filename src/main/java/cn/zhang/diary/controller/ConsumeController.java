package cn.zhang.diary.controller;

import cn.zhang.diary.dto.Result;
import cn.zhang.diary.model.Consume;
import cn.zhang.diary.service.ConsumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消费
 */
@Controller
@RequestMapping("/consume")
public class ConsumeController {

    @Resource
    private ConsumeService consumeService;

    /**
     * 查询列表
     *
     * @param consume
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result queryList(Consume consume) {
        Result result = new Result();
        List<Consume> list = consumeService.queryList(consume);
        result.addObject("list", list);
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(Consume consume) {
        Result result = new Result();
        if (null != consume.getId()) {
            consumeService.add(consume);
        } else {
            consumeService.update(consume);
        }
        return result;
    }
}
