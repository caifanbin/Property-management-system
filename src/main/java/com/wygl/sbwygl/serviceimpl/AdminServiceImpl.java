package com.wygl.sbwygl.serviceimpl;

import com.wygl.sbwygl.bean.Admin;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.mapper.AdminMapper;
import com.wygl.sbwygl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username,String password) {
        return adminMapper.login(username,password);

    }

    @Override
    public Page getAdminAll(Map map) {
        Page page = new Page((Integer) map.get("pageno"),(Integer) map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<Admin> admins =  adminMapper.queryList(map);
        Integer totalsize = adminMapper.querycount(map);
        page.setDatas(admins);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public void saveAdmin(Admin admin) {
        admin.setLoginPwd("666");
        adminMapper.saveAdmin(admin);

    }

    @Override
    public void deleteAdminById(Integer id) {
        adminMapper.deleteAdminById(id);
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminMapper.getAdminById(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }
}
