package com.wygl.sbwygl.service;

import com.wygl.sbwygl.bean.Rs;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;

import java.util.Map;

public interface RsService {
     void saveRs(Rs rs);

    Page queryPage(Map map);

    AjaxResult deleteRs(Integer id);

    Rs getRsById(Integer id);

    AjaxResult updateRs(Rs rs);
}
