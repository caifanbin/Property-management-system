package com.wygl.sbwygl.service;

import com.wygl.sbwygl.bean.Equip;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;

import java.util.Map;

public interface EquipService {
    Page queryPage(Map map);

    void saveEquip(Equip equip);

    AjaxResult deleteEquip(Integer id);

    Equip getEquipById(Integer id);

    AjaxResult updateEquip(Equip equip);

    AjaxResult getEquipByinName(Map map);
}
