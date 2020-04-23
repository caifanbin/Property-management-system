package com.wygl.sbwygl.serviceimpl;

import com.wygl.sbwygl.bean.Leaverword;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.mapper.LeaverWordMapper;
import com.wygl.sbwygl.service.LeaverWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LeaverWordServiceImpl implements LeaverWordService {

    @Autowired
    private LeaverWordMapper leaverWordMapper;

    @Override
    public List<Leaverword> getLeaverWordByType(Integer type) {
        return null;
    }

    @Override
    public Page queryPage(Map map) {
        Page page = new Page((Integer) map.get("pageno"),(Integer) map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<Leaverword> leaverwords =  leaverWordMapper.queryList(map);
        Integer totalsize = leaverWordMapper.querycount(map);
        page.setDatas(leaverwords);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public AjaxResult deleteLeaverword(Integer id) {
        AjaxResult result = new AjaxResult();
        try {
            leaverWordMapper.deleteLeaverword(id);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除失败");
        }
        return result;
    }

    @Override
    public Leaverword getLeaverWordById(Integer id) {
        return leaverWordMapper.getLeaverWordById(id);
    }

    @Override
    public AjaxResult updateLeaverword(Leaverword leaverword) {
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(leaverword.getAnswerContent())){
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = dateFormat.format(date);
                leaverword.setReDate(time);
                leaverWordMapper.updateLeaverword(leaverword);
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
    public AjaxResult getLeaverwordByUserId(Map map) {
        AjaxResult result = new AjaxResult();
        try {
            Page page = new Page((Integer) map.get("pageno"),(Integer) map.get("pagesize"));
            Integer startIndex = page.getStartIndex();
            map.put("startIndex",startIndex);
            List<Leaverword> leaverwords =  leaverWordMapper.queryListByUserId(map);
            Integer totalsize = leaverWordMapper.querycountByUserId(map);
            page.setDatas(leaverwords);
            page.setTotalsize(totalsize);
            result.setPage(page);
            result.setData(leaverwords);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("查询失败");
        }

        return result;
    }

    @Override
    public AjaxResult addLeaverWord(Leaverword leaverword) {
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(leaverword.getLeaverName())&&StringUtil.iNotEmpty(leaverword.getMark())&&StringUtil.iNotEmpty(leaverword.getType())
                    &&StringUtil.iNotEmpty(leaverword.getTitle())&&StringUtil.iNotEmpty(leaverword.getUserId())){}
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(date);
            leaverword.setTime(time);
            leaverWordMapper.addLeaverWord(leaverword);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("添加失败");
        }
        return result;
    }
}
