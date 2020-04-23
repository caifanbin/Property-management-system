package com.wygl.sbwygl.serviceimpl;

import com.wygl.sbwygl.bean.Change;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.mapper.ChangeMapper;
import com.wygl.sbwygl.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ChangeServiceImpl implements ChangeService {

    @Autowired
    private ChangeMapper changeMapper;

    @Override
    public void saveChange(Change change) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        change.setChangedate(date);
        System.out.println(change.toString());
        changeMapper.saveChange(change);
    }

    @Override
    public Change getChangeById(Integer id) {
        return changeMapper.getChangeById(id);
    }

    @Override
    public AjaxResult updateChange(Change change) {
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(change.getdNo())&&StringUtil.iNotEmpty(change.getzName())&&StringUtil.iNotEmpty(change.getType())
                    &&StringUtil.iNotEmpty(change.getChangeName())&&StringUtil.iNotEmpty(change.getWaterCase())&&StringUtil.iNotEmpty(change.geteCase())
                    &&StringUtil.iNotEmpty(change.getStopCase())&&StringUtil.iNotEmpty(change.getGascase())&&StringUtil.iNotEmpty(change.getMandCase())
                    &&StringUtil.iNotEmpty(change.getCases())){
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = df.format(new Date());
                change.setChangedate(date);
                changeMapper.updateChange(change);
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
    public AjaxResult deleteChange(Integer id) {
        AjaxResult result = new AjaxResult();
        try {
            changeMapper.deleteChange(id);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("删除失败");
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public AjaxResult getChangeByZname(Map map) {
        AjaxResult result = new AjaxResult();
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        try {
            List<Change> changeByZname = changeMapper.getChangeByZname(map);
            Integer totalsize = changeMapper.queryChangecountbyzName(map);
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

    @Override
    public Page queryPage(Map map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<Change> datas = changeMapper.queryChangeList(map);
        Integer totalsize = changeMapper.queryChangecount(map);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }
}
