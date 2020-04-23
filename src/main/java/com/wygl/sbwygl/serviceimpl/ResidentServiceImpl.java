package com.wygl.sbwygl.serviceimpl;

import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.mapper.ResidentMapper;
import com.wygl.sbwygl.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ResidentServiceImpl implements ResidentService {

    @Autowired
    private ResidentMapper residentMapper;

    @Override
    public Resident login(String username,String password) {
        return residentMapper.login(username, password);
    }



    @Override
    public void saveResident(Resident resident) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);
        System.out.println(time);
        resident.setDate(time);
        System.out.println(resident.getDate());
        resident.setPassword("666");
        residentMapper.saveResident(resident);
    }

    @Override
    public Page queryPage(Map map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<Resident> datas = residentMapper.queryList(map);
        Integer totalsize = residentMapper.querycount(map);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public Resident getResidentById(Integer id) {
        return residentMapper.getResidentById(id);
    }

    @Override
    public int updateResident(Resident resident) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);
        resident.setDate(time);
        return residentMapper.updateResident(resident);
    }

    @Override
    public int deleteResidentById(Integer id) {
        return residentMapper.deleteResidentById(id);
    }
}
