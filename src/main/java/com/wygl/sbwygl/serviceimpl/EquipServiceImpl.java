package com.wygl.sbwygl.serviceimpl;

import com.wygl.sbwygl.bean.Equip;
import com.wygl.sbwygl.bean.Pb;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.mapper.EquipMapper;
import com.wygl.sbwygl.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EquipServiceImpl implements EquipService {

    @Autowired
    private EquipMapper equipMapper;

    @Override
    public Page queryPage(Map map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<Equip> datas = equipMapper.queryList(map);
        Integer totalsize = equipMapper.querycount(map);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public void saveEquip(Equip equip) {
        equip.setRevalue("未修");
        equipMapper.saveEquip(equip);
    }

    @Override
    public AjaxResult deleteEquip(Integer id) {
        AjaxResult result = new AjaxResult();
        try {
            equipMapper.deleteEquip(id);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除失败");
        }

        return result;
    }

    @Override
    public Equip getEquipById(Integer id) {
        return equipMapper.getEquipById(id);
    }

    @Override
    public AjaxResult updateEquip(Equip equip) {
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(equip.getName())&&StringUtil.iNotEmpty(equip.getInName())&&StringUtil.iNotEmpty(equip.getTel())
                    &&StringUtil.iNotEmpty(equip.getAddress())&&StringUtil.iNotEmpty(equip.getBeDate())
                    &&StringUtil.iNotEmpty(equip.getMark())&&StringUtil.iNotEmpty(equip.getRevalue())){
                equipMapper.updateEquip(equip);
                result.setSuccess(true);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("修改失败");
        }
        return result;
    }

    @Override
    public AjaxResult getEquipByinName(Map map) {
        AjaxResult result = new AjaxResult();
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        try {
            List<Equip> changeByZname = equipMapper.getChangeByinName(map);
            Integer totalsize = equipMapper.queryChangecountbyinName(map);
            page.setDatas(changeByZname);
            page.setTotalsize(totalsize);
            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("查询失败");
        }
        return result;
    }
}
