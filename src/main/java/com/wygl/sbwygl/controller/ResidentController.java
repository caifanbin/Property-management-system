package com.wygl.sbwygl.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/resident")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @RequestMapping("toResident")
    public String toResident(){
        return "resident/resident_list";
    }
    @RequestMapping("/resident_add")
    public String residentAdd(){
        return "resident/resident_add";
    }

    @ResponseBody
    @RequestMapping("/getResidentAll")
    public Object getResidentAll(@RequestParam(value="pageno",required = false,defaultValue = "1") Integer pageno,
                                 @RequestParam(value = "pagesize",required = false,defaultValue = "5") Integer pagesize){
        Map map = new HashMap();
        AjaxResult result = new AjaxResult();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
            Page page =residentService.queryPage(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return  result;
    }

    @ResponseBody
    @RequestMapping("/saveResident")
    public Object saveResident(Resident resident){
        AjaxResult result = new AjaxResult();
        try {
            if (StringUtil.iNotEmpty(resident.getUsername())&&StringUtil.iNotEmpty(resident.getPassword())
                    &&StringUtil.iNotEmpty(resident.getAddress())&&StringUtil.iNotEmpty(resident.getPersionNo())
                    &&StringUtil.iNotEmpty(resident.getTelephone())&&StringUtil.iNotEmpty(resident.getSex())
                    &&StringUtil.iNotEmpty(resident.getType())) {

                residentService.saveResident(resident);
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

    @RequestMapping("/toUpdateResident")
    public String updateResident(Integer id,Map map){
        Resident resident = residentService.getResidentById(id);
        map.put("resident",resident);
        return "resident/resident_update";
    }



    @ResponseBody
    @RequestMapping("/updateResident")
    public Object updateResident(Resident resident){
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(resident.getUsername())&&StringUtil.iNotEmpty(resident.getPassword())
                    &&StringUtil.iNotEmpty(resident.getAddress())&&StringUtil.iNotEmpty(resident.getPersionNo())
                    &&StringUtil.iNotEmpty(resident.getTelephone())&&StringUtil.iNotEmpty(resident.getSex())) {

                int i = residentService.updateResident(resident);
                result.setSuccess(true);
            }else {
                result.setSuccess(false);
                result.setMessage("数据不能为空");
            }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("修改失败");
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteResident")
    public Object deleteResident(Integer id){
        AjaxResult result = new AjaxResult();
        try {
            int i = residentService.deleteResidentById(id);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("删除失败");
        }
        return result;
    }

    @RequestMapping("/goResident")
    public String goResident(Map map, HttpSession session){
       Resident ID= (Resident) session.getAttribute("loginResident");
        Resident resident = residentService.getResidentById(ID.getId());
        map.put("resident",resident);
        return "resident/resident_update1";
    }
}
