package com.wygl.sbwygl.controller;

import com.wygl.sbwygl.bean.Equip;
import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("equip")
public class EquipController {

    @Autowired
    private EquipService equipService;

    @RequestMapping("equipAdd")
    public String equipAdd(){
        return "equip/equip_add";
    }

    @RequestMapping("/toEquipList")
    public String toRsList(){
        return "equip/equip_list";
    }

    @ResponseBody
    @RequestMapping("/getEquipAll")
    public Object getRsList(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
                            @RequestParam(value = "pagesize",required = false,defaultValue = "5") Integer pagesize){
        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
            Page page =equipService.queryPage(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/saveEquip")
    public Object saveEquip(Equip equip){
        AjaxResult result = new AjaxResult();

        try {

            if (StringUtil.iNotEmpty(equip.getName())&&StringUtil.iNotEmpty(equip.getInName())&&StringUtil.iNotEmpty(equip.getTel())
                    &&StringUtil.iNotEmpty(equip.getAddress())&&StringUtil.iNotEmpty(equip.getBeDate())&&StringUtil.iNotEmpty(equip.getMark())) {

                equipService.saveEquip(equip);
                result.setSuccess(true);
            }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("保存失败");
        }

        return result;

    }

    @ResponseBody
    @RequestMapping("/deleteEquip")
    public Object deleteEquip(Integer id){
        AjaxResult result = equipService.deleteEquip(id);
        return result;
    }

    @RequestMapping("/toUpdateEquip")
    public String toUpdateEquip(Integer id,Map map){
        Equip equip =equipService.getEquipById(id);
        map.put("equip",equip);
        return "equip/equip_update";
    }

    @ResponseBody
    @RequestMapping("/updateEquip")
    public Object updateEquip(Equip equip){
        AjaxResult result = equipService.updateEquip(equip);
        return result;
    }

    @RequestMapping("/goEquipList")
    public String goEquipList(){
        return "equip/equip_list1";
    }

    @ResponseBody
    @RequestMapping("/getEquipByinName")
    public Object getChangeByzName(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
                                   @RequestParam(value = "pagesize",required = false,defaultValue = "5") Integer pagesize
            , HttpSession session){

        Resident loginResident = (Resident) session.getAttribute("loginResident");
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        map.put("inName",loginResident.getUsername());
        return equipService.getEquipByinName(map);

    }

}
