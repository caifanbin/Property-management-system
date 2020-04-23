package com.wygl.sbwygl.serviceimpl;

import com.wygl.sbwygl.bean.CarNum;
import com.wygl.sbwygl.bean.CarOrder;
import com.wygl.sbwygl.bean.Equip;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.mapper.CarMapper;
import com.wygl.sbwygl.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;


    @Override
    public Page getCarNum(Map map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<CarNum> datas = carMapper.queryCarNum(map);
        Integer totalsize = carMapper.queryCarNumcount(map);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public Page getCarOrderList(Map map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<CarOrder> datas = carMapper.queryCarOrder(map);
        Integer totalsize = carMapper.queryCarOrdercount(map);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public void saveCarOrder(CarOrder carOrder) {
        if (StringUtil.iNotEmpty(carOrder.getAddress())&&StringUtil.iNotEmpty(carOrder.getCarAddress())
                &&StringUtil.iNotEmpty(carOrder.getPersionNo())&&StringUtil.iNotEmpty(carOrder.getTelephone())
                &&StringUtil.iNotEmpty(carOrder.getUsername())&&StringUtil.iNotEmpty(carOrder.getCarimage())) {
            carOrder.setState("F");
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(date);
            carOrder.setChangedate(time);
            carMapper.saveCarOrder(carOrder);
        }
    }

    @Override
    public CarOrder getCarOrderById(Integer id) {
        return carMapper.getCarOrderById(id);
    }

    @Override
    public AjaxResult updateCarOrder(CarOrder carOrder) {
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(carOrder.getState())){
                carMapper.updateCarOrder(carOrder);
                result.setSuccess(true);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("修改失败");
        }
        return result;
    }

    @Override
    public AjaxResult deleteCarOrder(Integer id) {
        AjaxResult result = new AjaxResult();
        try {
            carMapper.deleteCarOrder(id);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除失败");
        }
        return result;
    }

    @Override
    public AjaxResult getCarOrderListByUserid(Map map) {
        AjaxResult result = new AjaxResult();
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        try {
            List<CarOrder> changeByZname = carMapper.getChangeByUserid(map);
            Integer totalsize = carMapper.queryChangecountbyUserid(map);
            page.setDatas(changeByZname);
            page.setTotalsize(totalsize);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;
    }
}
