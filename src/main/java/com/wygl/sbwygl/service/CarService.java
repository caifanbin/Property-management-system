package com.wygl.sbwygl.service;

import com.wygl.sbwygl.bean.CarOrder;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;

import java.util.Map;

public interface CarService {
    Page getCarNum(Map map);

    Page getCarOrderList(Map map);

    void saveCarOrder(CarOrder carOrder);

    CarOrder getCarOrderById(Integer id);

    AjaxResult updateCarOrder(CarOrder carOrder);

    AjaxResult deleteCarOrder(Integer id);

    AjaxResult getCarOrderListByUserid(Map map);
}
