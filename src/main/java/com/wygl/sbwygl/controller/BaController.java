package com.wygl.sbwygl.controller;

import com.wygl.sbwygl.bean.Ba;
import com.wygl.sbwygl.bean.Pb;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.service.BaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("ba")
public class BaController {

    @Autowired
    private BaService baService;

    @RequestMapping("baAdd")
    public String baAdd(){
        return "ba/ba_add";
    }

    @RequestMapping("baAddPb")
    public String baAddPb(){
        return "ba/ba_add_pb";
    }

    @RequestMapping("toBaList")
    public String toAdminList(){
        return "ba/ba_list";
    }


    @RequestMapping("/bapbList")
    public String bapbList(){
        return "ba/bapb_list";
    }


    @ResponseBody
    @RequestMapping("/getBapb")
    public Object getBapb(@RequestParam(value = "pageno",required = false,defaultValue = "1")Integer pageno,
                          @RequestParam(value = "pagesize",defaultValue = "5",required = false) Integer pagesize){
        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
            Page page =baService.queryPbPage(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/getBaAll")
    public Object getAdminAll(@RequestParam(value = "pageno",defaultValue = "1",required = false) Integer pageno,
                              @RequestParam(value = "pagesize",defaultValue = "5",required = false) Integer pagesize){

        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
            Page page =baService.queryPage(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/saveBa")
    public Object saveBa(Ba ba){
        AjaxResult result = new AjaxResult();
        try {
            if (StringUtil.iNotEmpty(ba.getName())&&StringUtil.iNotEmpty(ba.getBegDate())
                    &&StringUtil.iNotEmpty(ba.getPersionNo())
                    &&StringUtil.iNotEmpty(ba.getPost())&&StringUtil.iNotEmpty(ba.getSex())) {

                baService.saveBa(ba);
                result.setSuccess(true);
            }else {
                result.setMessage("数据不能为空");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("保存失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/saveBapb")
    public Object saveBapb(Pb pb){
        AjaxResult result = new AjaxResult();
        try {
            if (StringUtil.iNotEmpty(pb.getName())&&StringUtil.iNotEmpty(pb.getStartTime())&&StringUtil.iNotEmpty(pb.getEndTime())) {

                baService.saveBapb(pb);
                result.setSuccess(true);
            }else {
                result.setMessage("数据不能为空");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("保存失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteBa")
    public Object deleteBa(Integer id){
        AjaxResult result =  new AjaxResult();
        try {
            baService.deleteBaById(id);
            result.setSuccess(true);

        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除失败");
        }
        return  result;
    }

    @RequestMapping("/toUpdateBa")
    public String toUpdateBa(Integer id,Map map){
        Ba ba = baService.getBaById(id);
        map.put("ba",ba);
        return "ba/ba_update";
    }
    @ResponseBody
    @RequestMapping("/updateBa")
    public Object updateBa(Ba ba){
        AjaxResult result = baService.updateBa(ba);
        return result;
    }

    @ResponseBody
    @RequestMapping("/updateBapb")
    public Object updateBapb(Pb pb){
        AjaxResult result = baService.updateBapb(pb);
        return result;
    }
    @ResponseBody
    @RequestMapping("/deleteBapb")
    public Object deleteBapb(Integer id){
        AjaxResult result =  new AjaxResult();
        try {
            baService.deleteBapbById(id);
            result.setSuccess(true);

        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除失败");
        }
        return  result;
    }

    @RequestMapping("/toUpdateBapb")
    public String toUpdateBapb(Integer id,Map map){
       Pb pb = baService.getBapbById(id);
        map.put("pb",pb);
        return "ba/bapb_update";
    }


}
