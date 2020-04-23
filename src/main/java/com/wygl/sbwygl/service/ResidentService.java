package com.wygl.sbwygl.service;

import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.commons.Page;

import java.util.List;
import java.util.Map;

public interface ResidentService {
     Resident login(String username, String password);

    void saveResident(Resident resident);

    Page queryPage(Map map);

    Resident getResidentById(Integer id);

    int updateResident(Resident resident);

    int deleteResidentById(Integer id);
}
