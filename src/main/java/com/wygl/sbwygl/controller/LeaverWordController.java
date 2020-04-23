package com.wygl.sbwygl.controller;

import com.wygl.sbwygl.bean.Leaverword;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.service.LeaverWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/leaverword")
public class LeaverWordController {


    @Autowired
    private LeaverWordService leaverWordService;

    @RequestMapping("/getLeaverWord")
    public String getLeaverWord(String type, Model model){
        System.out.println(type);
        model.addAttribute("type",type);
        return "leaverword/leaverword_list";
    }

    @ResponseBody
    @RequestMapping("/leaverWordList")
    public Object leaverWordList(@RequestParam(value = "pageno",defaultValue = "1",required = false) Integer pageno,
                                 @RequestParam(value = "pagesize",defaultValue = "5",required = false) Integer pagesize,
                                 @RequestParam(value = "type",required = false)String type){
        System.out.println("开始");
        System.out.println(type);
        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        map.put("type",type);
        try {
            Page page =leaverWordService.queryPage(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteLeaverword")
    public Object deleteLeaverword(Integer id){
        return leaverWordService.deleteLeaverword(id);
    }

    @RequestMapping("/toUpdateleaverword")
    public String toUpdateleaverword(Integer id,Map map){
        Leaverword leaverword =leaverWordService.getLeaverWordById(id);
        map.put("leaverword",leaverword);
        return "leaverword/leaverword_update";
    }

    @ResponseBody
    @RequestMapping("/updateLeaverword")
    public  Object updateLeaverword(Leaverword leaverword){
        return leaverWordService.updateLeaverword(leaverword);
    }

    @RequestMapping("/toAddLeaverWord")
    public String addLeaverWord(){
        return "leaverword/leaverword_add";
    }

    @ResponseBody
    @RequestMapping("/addLeaverWord")
    public Object addLeaverWord(Leaverword leaverword){
        return  leaverWordService.addLeaverWord(leaverword);
    }

    @RequestMapping("/leaverwordListByUserId")
    public String leaverwordByUserId(){
        return "leaverword/leaverword_list1";
    }

    @ResponseBody
    @RequestMapping("/getLeaverwordByUserId")
    public Object getLeaverwordByUserId(@RequestParam(value = "pageno",defaultValue = "1",required = false) Integer pageno,
                                 @RequestParam(value = "pagesize",defaultValue = "5",required = false) Integer pagesize,
                                 @RequestParam(value = "userId",required = false) String userId) {
        System.out.println("++++++++++++++++++++++++++++++");
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        map.put("userId",userId);
        return leaverWordService.getLeaverwordByUserId(map);
    }
    }
