package com.wygl.sbwygl.service;

import com.wygl.sbwygl.bean.Leaverword;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;

import java.util.List;
import java.util.Map;

public interface LeaverWordService {
    List<Leaverword> getLeaverWordByType(Integer type);

    Page queryPage(Map map);

    AjaxResult deleteLeaverword(Integer id);

    Leaverword getLeaverWordById(Integer id);

    AjaxResult updateLeaverword(Leaverword leaverword);

    AjaxResult getLeaverwordByUserId(Map map);

    AjaxResult addLeaverWord(Leaverword leaverword);
}
