package com.wygl.sbwygl.service;

import com.wygl.sbwygl.bean.Change;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;

import java.util.Map;

public interface ChangeService {
    Page queryPage(Map map);

    void saveChange(Change change);

    Change getChangeById(Integer id);

    AjaxResult updateChange(Change change);

    AjaxResult deleteChange(Integer id);

    AjaxResult getChangeByZname(Map map);
}
