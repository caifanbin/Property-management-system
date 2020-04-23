package com.wygl.sbwygl.service;

import com.wygl.sbwygl.bean.Admin;
import com.wygl.sbwygl.commons.Page;

import java.util.Map;

public interface AdminService {

public Admin login(String username, String password);

    Page getAdminAll(Map map);

    void saveAdmin(Admin admin);

    void deleteAdminById(Integer id);

    Admin getAdminById(Integer id);

    void updateAdmin(Admin admin);
}
