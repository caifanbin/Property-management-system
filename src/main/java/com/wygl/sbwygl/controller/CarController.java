package com.wygl.sbwygl.controller;


import com.wygl.sbwygl.bean.CarOrder;
import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/car")
public class CarController {
    @Value("${properties.uploadPath}")
    private String uplaodPath;

    @Autowired
    private CarService carService;

    @RequestMapping("carOrderAdd")
    public String carOrderAdd(){
        return "car/carOrder_add";
    }

    @RequestMapping("/carNumList")
    public String carNumList(){
        return "car/carNum_list";
    }

    @ResponseBody
    @RequestMapping("/getCarNum")
    public Object getCarNum(@RequestParam(value = "pageno",defaultValue ="1",required = false)Integer pageno,
                            @RequestParam(value = "pagesize",defaultValue = "5",required = false)Integer pagesize){
        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
            Page page =carService.getCarNum(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;

    }

    @RequestMapping("/getCarOrderList")
    public String getCarOrderList(){
        return "car/carOrder_list";
    }

    @ResponseBody
    @RequestMapping("/getCarOrderListAll")
    public Object getCarOrderListAll(@RequestParam(value = "pageno",defaultValue ="1",required = false)Integer pageno,
                                     @RequestParam(value = "pagesize",defaultValue = "5",required = false)Integer pagesize){
        AjaxResult result = new AjaxResult();
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        try {
            Page page =carService.getCarOrderList(map);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/saveCarOrder")
    public Object saveCarOrder(HttpServletRequest request, CarOrder carOrder, HttpSession session){
        AjaxResult result = new AjaxResult();
        try {
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
            MultipartFile mfile = mreq.getFile("carimg");
            String name = mfile.getOriginalFilename();//java.jpg
            String extname= name.substring(name.lastIndexOf("."));//.jpg
            String iconpath = UUID.randomUUID().toString()+extname;//XXXX.jpg
            System.out.println(iconpath);
            mfile.transferTo(new File(uplaodPath+iconpath));

            carOrder.setCarimage("/carImage/"+iconpath);
            carService.saveCarOrder(carOrder);

            result.setSuccess(true);

        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping("/toUpdateCarOrder")
    public String toUpdateCarOrder(Integer id,Map map){
        CarOrder carOrder =carService.getCarOrderById(id);
        map.put("co",carOrder);
        return "car/carorder_update";
    }

    @ResponseBody
    @RequestMapping("/updateCarOrder")
    public Object updateCarOrder(CarOrder carOrder){
        return carService.updateCarOrder(carOrder);
    }

    @ResponseBody
    @RequestMapping("/deleteCarOrder")
    public Object deleteCarOrder(Integer id){
        return carService.deleteCarOrder(id);
    }

    @RequestMapping("/goCarOrderList")
    public String goCarOrderList(){
        return "car/carOrder_list1";
    }

    @ResponseBody
    @RequestMapping("/getCarOrderListByUserid")
    public Object getChangeByzName(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
                                   @RequestParam(value = "pagesize",required = false,defaultValue = "5") Integer pagesize
            , HttpSession session){

        Resident loginResident = (Resident) session.getAttribute("loginResident");
        Map map = new HashMap();
        map.put("pageno",pageno);
        map.put("pagesize",pagesize);
        map.put("userid",loginResident.getUsername());
        return carService.getCarOrderListByUserid(map);

    }

}
