package com.wygl.sbwygl.service;

import com.wygl.sbwygl.bean.Chanel;
import com.wygl.sbwygl.bean.Rs;
import com.wygl.sbwygl.commons.Page;

import java.util.Map;

public interface ChanelService {
    Page queryPage(Map map);

    void saveChanel(Chanel chanel);

    void deleteChanelById(Integer id);



    void updateChanel(Chanel chanel);

    Chanel getChanelById(Integer id);
}
