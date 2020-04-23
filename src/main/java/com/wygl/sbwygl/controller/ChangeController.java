package com.wygl.sbwygl.controller;

import com.wygl.sbwygl.bean.Chanel;
import com.wygl.sbwygl.bean.Change;
import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("change")
public class ChangeController {

    @Autowired
    private ChangeService changeService;

    @RequestMapping("changeAdd")
    public String changeAdd(){
        return "change/change_add";
    }

    @RequestMapping("/toChangeList")
    public String toRsList(){
        return "change/change_list";
    }

    @ResponseBody
    @RequestMapping("/getChangeAll")
    public Object getRsList(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
                            @RequestParam(value = "pagesize",required = false,defaultValue = "5") Integer pagesize){
        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
            Page page =changeService.queryPage(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/saveChange")
    public Object saveChange(Change change){
        AjaxResult result = new AjaxResult();

        try {

        if(StringUtil.iNotEmpty(change.getdNo())&&StringUtil.iNotEmpty(change.getzName())&&StringUtil.iNotEmpty(change.getType())
                &&StringUtil.iNotEmpty(change.getChangeName())&&StringUtil.iNotEmpty(change.getWaterCase())&&StringUtil.iNotEmpty(change.geteCase())
                &&StringUtil.iNotEmpty(change.getStopCase())&&StringUtil.iNotEmpty(change.getGascase())&&StringUtil.iNotEmpty(change.getMandCase())
                &&StringUtil.iNotEmpty(change.getCases())){

            System.out.println(change.toString());
            changeService.saveChange(change);
            result.setSuccess(true);
            result.setMessage("数据不能为空");
        }
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("保存失败");
        }
        return result;
    }

    @RequestMapping("/toUpdateChange")
    public String toUpdateChange(Integer id,Map map){
        Change change =changeService.getChangeById(id);
        map.put("change",change);
        return "change/change_update";
    }

    @ResponseBody
    @RequestMapping("/updateChange")
    public Object updateChange(Change change){
        AjaxResult result =changeService.updateChange(change);
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteChange")
    public Object deleteChange(Integer id){
        return changeService.deleteChange(id);
    }

    @RequestMapping("/goChangeList")
    public String goChangeList(){
        return "change/change_list1";
    }

    @ResponseBody
    @RequestMapping("/getChangeByzName")
    public Object getChangeByzName(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
                                   @RequestParam(value = "pagesize",required = false,defaultValue = "5") Integer pagesize
                                    ,HttpSession session){

        Resident loginResident = (Resident) session.getAttribute("loginResident");
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        map.put("zName",loginResident.getUsername());
        return changeService.getChangeByZname(map);

    }

    @RequestMapping("/goChange")
    public String goChange(Integer id,Map map){
        Change changeById = changeService.getChangeById(id);
        map.put("change",changeById);
        return "change/gochange";
    }
}
