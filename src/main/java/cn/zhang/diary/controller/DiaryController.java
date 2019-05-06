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
import java.util.Date;
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
        List<DiaryDTO> list = diaryService.queryList(diaryDTO);
        //计算合计
        double consume = 0;
        double income = 0;
        for (DiaryDTO dto : list) {
            if (null != dto.getConsume()) {
                consume += dto.getConsume();
            }
            if (null != dto.getIncome()) {
                income += dto.getIncome();
            }
        }
        DiaryDTO dto = new DiaryDTO();
        dto.setDate("合计");
        dto.setConsume(consume);
        dto.setIncome(income);
        dto.setWeather("");
        dto.setMood("");
        dto.setKeywords("");
        dto.setAddress("");
        dto.setType("");
        dto.setCreateTime(new Date());
        list.add(0, dto);

        Result result = new Result();
        result.addObject("list", list);
        return result;
    }

    /**
     * 新增日记
     *
     * @param request
     * @param diary
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(HttpServletRequest request, Diary diary) {
        String id = request.getSession().getAttribute("id").toString();
        diary.setUserId(Long.parseLong(id));
        if (null != diary.getId()) {
            diaryService.update(diary);
        } else {
            diaryService.add(diary);
        }
        Result result = new Result();
        return result;
    }

    /**
     * 查询一个日记
     *
     * @return
     */
    @RequestMapping("/queryById")
    @ResponseBody
    public Result add(Long id) {
        Diary diary = diaryService.queryById(id);
        Result result = new Result();
        result.addObject("diary", diary);
        return result;
    }


}
