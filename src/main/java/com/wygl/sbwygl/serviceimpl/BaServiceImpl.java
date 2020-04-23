package com.wygl.sbwygl.serviceimpl;

import com.wygl.sbwygl.bean.Ba;
import com.wygl.sbwygl.bean.Pb;
import com.wygl.sbwygl.bean.Resident;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.mapper.BaMapper;
import com.wygl.sbwygl.service.BaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaServiceImpl implements BaService {

@Autowired
private BaMapper baMapper;


    @Override
    public Page queryPage(Map map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<Ba> datas = baMapper.queryList(map);
        Integer totalsize = baMapper.querycount(map);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public void saveBa(Ba ba) {
        baMapper.saveBa(ba);
    }

    @Override
    public Page queryPbPage(Map map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<Pb> datas = baMapper.queryPbList(map);
        Integer totalsize = baMapper.queryPbcount(map);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public void saveBapb(Pb pb) {
        baMapper.saveBapb(pb);
    }

    @Override
    public void deleteBaById(Integer id) {
        baMapper.deleteBaById(id);
    }

    @Override
    public Ba getBaById(Integer id) {
        return baMapper.getBaById(id);
    }

    @Override
    public AjaxResult updateBa(Ba ba) {
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(ba.getName())&&StringUtil.iNotEmpty(ba.getPersionNo())&&StringUtil.iNotEmpty(ba.getBegDate())
                    &&StringUtil.iNotEmpty(ba.getSex())&&StringUtil.iNotEmpty(ba.getPost())){
                baMapper.updateBa(ba);
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
    public Pb getBapbById(Integer id) {
        return baMapper.getBapbById(id);
    }

    @Override
    public void deleteBapbById(Integer id) {
        baMapper.deleteBapbById(id);
    }

    @Override
    public AjaxResult updateBapb(Pb pb) {
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(pb.getName())&&StringUtil.iNotEmpty(pb.getEndTime())&&StringUtil.iNotEmpty(pb.getStartTime())){
                baMapper.updateBapb(pb);
                result.setSuccess(true);
            }

        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("修改失败");
        }
        return result;
    }

}
