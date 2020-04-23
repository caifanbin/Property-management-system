package com.wygl.sbwygl.controller;

import com.wygl.sbwygl.bean.Admin;
import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.service.AdminService;
import com.wygl.sbwygl.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ResidentService residentService;

    @ResponseBody
    @RequestMapping("/login")
    public Object login(String password, String username, String usertype,HttpSession session){
        System.out.println(usertype);
        System.out.println(username);
        System.out.println(password);
        System.out.println("CONTROLLER");
        AjaxResult result = new AjaxResult();
        if("1".equals(usertype)){
            Resident resident = residentService.login(username,password);
            System.out.println(resident);
            session.setAttribute("loginUser",resident.getUsername());
            session.setAttribute("loginResident",resident);
            result.setData(resident);
            result.setSuccess(true);
        }else if("2".equals(usertype)){
            Admin admin = adminService.login(password,username);
            session.setAttribute("loginUser",admin.getLoginName());
            System.out.println(admin.getLoginName());
            result.setData(admin);
            result.setSuccess(true);
        }else {
            System.out.println("123");
            result.setMessage("账户类型错误");
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/left")
    public String left(){
        return "commons/left";
    }

    @RequestMapping("/top")
    public String top(){
        return "commons/top";
    }

    @RequestMapping("/mainfra")
    public String mainfra(){
        return "commons/mainfra";
    }

    @RequestMapping("/index1")
    public String index1(){return "index1";}

    @RequestMapping("/left1")
    public String left1(){return "commons/left1";}
}
