package cn.zhang.diary.controller;

import cn.zhang.diary.dto.DiaryDTO;
import cn.zhang.diary.dto.Result;
import cn.zhang.diary.model.Diary;
import cn.zhang.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 日记Controller
 *
 * @Auther: zhangchao
 * @Date: 2019/5/5 13:49
 */
@Controller
@RequestMapping("/diary")
public class DiaryController {


    /**
     * 日记
     */
    @Autowired
    private DiaryService diaryService;

    /**
     * 查询列表
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result queryList(HttpServletRequest request, DiaryDTO diaryDTO) {
        String id = request.getSession().getAttribute("id").toString();
        diaryDTO.setUserId(Long.parseLong(id));
        List<Diary> list = diaryService.queryList(diaryDTO);
        Result result = new Result();
        result.addObject("list", list);
        return result;
    }



}
