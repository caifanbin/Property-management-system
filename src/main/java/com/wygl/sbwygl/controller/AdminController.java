package com.wygl.sbwygl.controller;

import com.wygl.sbwygl.bean.Admin;
import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("adminAdd")
    public String adminAdd(){
        return "admin/admin_add";
    }

    @RequestMapping("toAdminList")
    public String toAdminList(){
        return "admin/admin_list";
    }

    @ResponseBody
    @RequestMapping("/getAdminAll")
    public Object getAdminAll(@RequestParam(value = "pageno",defaultValue = "1",required = false) Integer pageno,
                              @RequestParam(value = "pagesize",defaultValue = "5",required = false) Integer pagesize){

        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
           Page page =adminService.getAdminAll(map);
           result.setPage(page);
           result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/saveAdmin")
    public Object saveResident(Admin admin){
        AjaxResult result = new AjaxResult();
        try {
            if (StringUtil.iNotEmpty(admin.getLoginName())&&StringUtil.iNotEmpty(admin.getAdminName())
                    &&StringUtil.iNotEmpty(admin.getBegDate())&&StringUtil.iNotEmpty(admin.getPersionNo())
                    &&StringUtil.iNotEmpty(admin.getPost())&&StringUtil.iNotEmpty(admin.getSex())) {

                adminService.saveAdmin(admin);
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
    @RequestMapping("/deleteAdmin")
    public Object deleteAdmin(Integer id){
        AjaxResult result = new AjaxResult();
        try {
            adminService.deleteAdminById(id);
            result.setSuccess(true);
        }catch (Exception e){
            result.setMessage("删除失败");
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping("/toUpdateAdmin")
    public String toUpdateAdmin(Integer id,Map map){
        Admin admin = adminService.getAdminById(id);
        map.put("admin",admin);
        return "admin/admin_update";
    }

    @ResponseBody
    @RequestMapping("/updateAdmin")
    public Object updateAdmin(Admin admin){
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(admin.getAdminName())&&StringUtil.iNotEmpty(admin.getLoginName())
                    &&StringUtil.iNotEmpty(admin.getLoginPwd())&&StringUtil.iNotEmpty(admin.getPersionNo())
                    &&StringUtil.iNotEmpty(admin.getPost())&&StringUtil.iNotEmpty(admin.getSex())&&StringUtil.iNotEmpty(admin.getBegDate())) {
                adminService.updateAdmin(admin);
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
}
