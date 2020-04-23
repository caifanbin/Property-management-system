package com.wygl.sbwygl.serviceimpl;

import com.wygl.sbwygl.bean.Chanel;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.mapper.ChanelMapper;
import com.wygl.sbwygl.service.ChanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChanelServiceImpl implements ChanelService {

    @Autowired
    private ChanelMapper chanelMapper;

    @Override
    public void saveChanel(Chanel chanel) {
        chanelMapper.saveChanel(chanel);
    }

    @Override
    public void deleteChanelById(Integer id) {
        chanelMapper.deleteChanelById(id);
    }

    @Override
    public void updateChanel(Chanel chanel) {
        chanelMapper.updateChanel(chanel);
    }

    @Override
    public Chanel getChanelById(Integer id) {
        return chanelMapper.getChanelById(id);
    }

    @Override
    public Page queryPage(Map map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<Chanel> datas = chanelMapper.queryRsList(map);
        Integer totalsize = chanelMapper.queryRscount(map);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }
}
