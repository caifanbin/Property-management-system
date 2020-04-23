package com.wygl.sbwygl.controller;

import com.wygl.sbwygl.bean.Rs;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.service.RsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("rs")
public class RsController {

    @Autowired
    private RsService rsService;

    @RequestMapping("rsAdd")
    public String rsAdd(){
        return "rs/rs_add";
    }

    @RequestMapping("/toRsList")
    public String toRsList(){
        return "rs/rs_list";
    }

    @ResponseBody
    @RequestMapping("/getRsAll")
    public Object getRsList(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
                            @RequestParam(value = "pagesize",required = false,defaultValue = "5") Integer pagesize){
        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
            Page page =rsService.queryPage(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/saveRs")
    public Object saveRs(Rs rs){
        AjaxResult result = new AjaxResult();
        try {

            if (StringUtil.iNotEmpty(rs.getAdminName())&&StringUtil.iNotEmpty(rs.getBegDate())
                    &&StringUtil.iNotEmpty(rs.getPersionNo())
                    &&StringUtil.iNotEmpty(rs.getPost())&&StringUtil.iNotEmpty(rs.getSex())) {

                rsService.saveRs(rs);
                result.setSuccess(true);
            }else {
                result.setMessage("数据不能为空");
                result.setSuccess(false);
            }

        }catch (Exception e){

        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteRs")
    public Object deleteRs(Integer id){
        return rsService.deleteRs(id);
    }

    @RequestMapping("/toUpdateRs")
    public String toUpdateRs(Integer id,Map map){
        Rs rs = rsService.getRsById(id);
        map.put("rs",rs);
        return "rs/rs_update";
    }

    @ResponseBody
    @RequestMapping("/updateRs")
    public Object updateRs(Rs rs){
        return rsService.updateRs(rs);
    }
}
