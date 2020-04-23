package com.wygl.sbwygl.service;

import com.wygl.sbwygl.bean.Ba;
import com.wygl.sbwygl.bean.Pb;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;

import java.util.Map;

public interface BaService {
    Page queryPage(Map map);

    void saveBa(Ba ba);

    Page queryPbPage(Map map);

    void saveBapb(Pb pb);

    void deleteBaById(Integer id);

    Ba getBaById(Integer id);

    AjaxResult updateBa(Ba ba);

    Pb getBapbById(Integer id);

    void deleteBapbById(Integer id);

    AjaxResult updateBapb(Pb pb);
}
