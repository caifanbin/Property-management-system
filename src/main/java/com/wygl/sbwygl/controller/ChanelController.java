package com.wygl.sbwygl.controller;

import com.wygl.sbwygl.bean.Chanel;
import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.bean.Rs;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.service.ChanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("chanel")
public class ChanelController {


    @Autowired
    private ChanelService chanelService;

    @RequestMapping("chanelAdd")
    public String chanelAdd(){
        return "chanel/chanel_add";
    }
    @RequestMapping("/toChanelList")
    public String toRsList(){
        return "chanel/chanel_list";
    }

    @ResponseBody
    @RequestMapping("/getChanelAll")
    public Object getRsList(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
                            @RequestParam(value = "pagesize",required = false,defaultValue = "5") Integer pagesize){
        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
            Page page =chanelService.queryPage(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/deleteChanel")
    public Object deleteChanel(Integer id){
        AjaxResult result = new AjaxResult();
        try {
            chanelService.deleteChanelById(id);
            result.setSuccess(true);
        }catch (Exception e){
            result.setMessage("删除失败");
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping("/toUpdateChanel")
    public String updateResident(Integer id,Map map) {
        Chanel chanel = chanelService.getChanelById(id);
        map.put("chanel", chanel);
        return "chanel/chanel_update";
    }

    @ResponseBody
    @RequestMapping("/updateChanel")
    public Object updateResident(Chanel chanel,HttpSession session){
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(chanel.getNum())&&StringUtil.iNotEmpty(chanel.getMark())
                    &&StringUtil.iNotEmpty(chanel.getModel())&&StringUtil.iNotEmpty(chanel.getName())) {
                String loginUser = (String)session.getAttribute("loginUser");
                chanel.setInName(loginUser);
                chanelService.updateChanel(chanel);
                result.setSuccess(true);
            }else {
                result.setSuccess(false);
                result.setMessage("数据不能为空");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("修改失败");
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/saveChanel")
    public Object saveRs(Chanel  chanel, HttpSession session){
        AjaxResult result = new AjaxResult();
        try {

            if (StringUtil.iNotEmpty(chanel.getName())&&StringUtil.iNotEmpty(chanel.getBeDate())
                    &&StringUtil.iNotEmpty(chanel.getNum())
                    &&StringUtil.iNotEmpty(chanel.getModel())&&StringUtil.iNotEmpty(chanel.getMark())) {

                String loginUser = (String)session.getAttribute("loginUser");
                chanel.setInName(loginUser);
                chanelService.saveChanel(chanel);
                result.setSuccess(true);
            }else {
                result.setMessage("数据不能为空");
                result.setSuccess(false);
            }

        }catch (Exception e){

        }
        return result;
    }
}
