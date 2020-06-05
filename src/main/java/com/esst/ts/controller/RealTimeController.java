package com.esst.ts.controller;
import com.esst.ts.constants.Constants;
import com.esst.ts.model.Result;
import com.esst.ts.model.examUserdetailscore;
import com.esst.ts.model.scoreModel;
import com.esst.ts.service.examUserdetailscoreService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * 实时数据
 * SHY
 */

@Controller
@RequestMapping("/web/v1/fang")
public class RealTimeController {
    @Resource
    private examUserdetailscoreService userdetailservice;
    @ResponseBody
    @RequestMapping("/updatescore")
   public Result updatescore(@RequestParam(value="score_id") String score_id,
                             @RequestParam(value="stu_number") String stu_number,
                             @RequestParam(value="stu_name") String stu_name,
                             @RequestParam(value="tasklist_name") String tasklist_name,
                             @RequestParam(value="task_name") String task_name,
                             @RequestParam(value="task_score") String task_score,
                             @RequestParam(value="tasklist_score") String tasklist_score,
                             @RequestParam(value="train_id") String train_id,
                           HttpServletRequest request){
       RequestContext requestcontext=new RequestContext(request);
       Result r = new Result();
       if(Constants.scoredataDic.containsKey(stu_number))
       {
           scoreModel m = Constants.scoredataDic.get(stu_number);
           m.setId(train_id);
           m.setMachine_id("PC01");
           m.setUser_name(stu_name);
           m.setStudent_num(stu_number);
           m.setTemplate_id("任务单或试卷id");
           m.setTemplate_name(tasklist_name);
           m.setTask_id("任务或试题id");
           m.setTask_name(task_name);
           m.setScore(task_score);
           m.setTotal_score(tasklist_score);
           m.setLearning_time("25.6");
           m.setStatus("1");
           m.setDetailesscore("带排版的详细成绩");
           m.setReport_url("www.esonline.com/report.pdf");
       }
       else
       {
           scoreModel m = new scoreModel();
           m.setId(train_id);
           m.setMachine_id("PC01");
           m.setUser_name(stu_name);
           m.setStudent_num(stu_number);
           m.setTemplate_id("任务单或试卷id");
           m.setTemplate_name(tasklist_name);
           m.setTask_id("任务或试题id");
           m.setTask_name(task_name);
           m.setScore(task_score);
           m.setTotal_score(tasklist_score);
           m.setLearning_time("25.6");
           m.setStatus("1");
           m.setDetailesscore("带排版的详细成绩");
           m.setReport_url("www.esonline.com/report.pdf");
           Constants.scoredataDic.put(stu_number,m);
       }
//        for (int i = 0; i < 5; i++) {
//            scoreModel m = new scoreModel();
//            m.setId(toString().valueOf(i + 1));
//            m.setMachine_id("PC01");
//            m.setUser_name("王五"+toString().valueOf(i + 1));
//            m.setStudent_num("1100");
//            m.setTemplate_id("任务单或试卷id");
//            m.setTemplate_name("任务单或试卷名");
//            m.setTask_id("任务或试题id");
//            m.setTask_name("任务或试题名");
//            m.setScore("10.3");
//            m.setTotal_score("60.1");
//            m.setLearning_time("25.6");
//            m.setStatus("1");
//            m.setDetailesscore("带排版的详细成绩");
//            m.setReport_url("www.esonline.com/report.pdf");
//            Constants.scoredataDic.put("王五"+toString().valueOf(i + 1),m);
//        }
        //examUserdetailscore score=new examUserdetailscore();
        //score.setUdsUserid(Integer.parseInt(score_id));
        //userdetailservice.updatescore(score);;
        r.setMsg("更新成功");
    return  r;
    }

}
